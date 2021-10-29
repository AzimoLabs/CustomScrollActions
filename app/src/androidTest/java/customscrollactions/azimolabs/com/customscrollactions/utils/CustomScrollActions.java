package customscrollactions.azimolabs.com.customscrollactions.utils;

/**
 * Created by F1sherKK on 18/05/2017.
 */

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;

import static customscrollactions.azimolabs.com.customscrollactions.utils.CustomScrollActions.ScrollType.COORDINATOR_SCROLL;
import static customscrollactions.azimolabs.com.customscrollactions.utils.CustomScrollActions.ScrollType.NESTED_SCROLL;
import static customscrollactions.azimolabs.com.customscrollactions.utils.CustomScrollActions.ScrollType.NORMAL_SCROLL;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by F1sherKK on 07/03/2017.
 */

public class CustomScrollActions {
    public enum ScrollType {
        COORDINATOR_SCROLL,
        NESTED_SCROLL,
        NORMAL_SCROLL
    }

    public static ViewAction scrollTo() {
        return new ViewAction() {
            private ScrollType scrollType;

            @Override
            public Matcher<View> getConstraints() {
                return new TypeSafeMatcher<View>() {
                    @Override
                    protected boolean matchesSafely(View target) {
                        Matcher nestedScrollViewMatcher =
                                Matchers.allOf(
                                        isDescendantOfA(isAssignableFrom(NestedScrollView.class)),
                                        withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
                                );

                        Matcher coordinatorLayoutMatcher =
                                Matchers.allOf(
                                        isDescendantOfA(isAssignableFrom(CoordinatorLayout.class)),
                                        withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
                                );

                        if (nestedScrollViewMatcher.matches(target)) {
                            scrollType = NESTED_SCROLL;
                            return true;
                        } else if (coordinatorLayoutMatcher.matches(target)) {
                            scrollType = COORDINATOR_SCROLL;
                            return true;
                        } else {
                            scrollType = NORMAL_SCROLL;
                            return ViewActions.scrollTo().getConstraints().matches(target);
                        }
                    }

                    @Override
                    public void describeTo(Description description) {
                        description.appendText("View is not assignable from class NestedScrollView or CoordinatorLayout.");
                    }
                };
            }

            @Override
            public String getDescription() {
                return "scroll to";
            }

            @Override
            public void perform(UiController uiController, View view) {
                switch (scrollType) {
                    case NESTED_SCROLL:
                        nestedScrollTo(view, getDescription());
                        break;
                    case COORDINATOR_SCROLL:
                        coordinatorScrollTo(view, getDescription());
                        break;
                    case NORMAL_SCROLL:
                        ViewActions.scrollTo().perform(uiController, view);
                        break;
                }
                uiController.loopMainThreadUntilIdle();
            }
        };
    }

    private static void nestedScrollTo(View view, String description) {
        try {
            NestedScrollView nestedScrollView = (NestedScrollView)
                    findFirstParentLayoutOfClass(view, NestedScrollView.class);
            if (nestedScrollView != null) {
                CoordinatorLayout coordinatorLayout =
                        (CoordinatorLayout) findFirstParentLayoutOfClass(view, CoordinatorLayout.class);
                if (coordinatorLayout != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout =
                            findCollapsingToolbarLayoutChildIn(coordinatorLayout);
                    if (collapsingToolbarLayout != null) {
                        int toolbarHeight = collapsingToolbarLayout.getHeight();
                        nestedScrollView.startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
                        nestedScrollView.dispatchNestedPreScroll(0, toolbarHeight, null, null);
                    }
                }

                // ensure view fully visible
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                view.requestRectangleOnScreen(rect, true);
            } else {
                throw new Exception("Unable to find NestedScrollView parent.");
            }
        } catch (Exception e) {
            throw new PerformException.Builder()
                    .withActionDescription(description)
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(e)
                    .build();
        }
    }

    private static void coordinatorScrollTo(View view, String description) {
        try {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)
                    findFirstParentLayoutOfClass(view, CoordinatorLayout.class);
            if (coordinatorLayout != null) {
                NestedScrollingChild nestedScrollingChild =
                        (NestedScrollingChild) findFirstParentLayoutOfClass(view, NestedScrollingChild.class);
                if (nestedScrollingChild != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout =
                            findCollapsingToolbarLayoutChildIn(coordinatorLayout);
                    if (collapsingToolbarLayout != null) {
                        int toolbarHeight = collapsingToolbarLayout.getHeight();
                        nestedScrollingChild.startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
                        nestedScrollingChild.dispatchNestedPreScroll(0, toolbarHeight, null, null);
                    }
                }

                // ensure view fully visible
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                view.requestRectangleOnScreen(rect, true);
            } else {
                throw new Exception("Unable to find CoordinatorLayout parent.");
            }
        } catch (Exception e) {
            throw new PerformException.Builder()
                    .withActionDescription(description)
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(e)
                    .build();
        }
    }

    private static CollapsingToolbarLayout findCollapsingToolbarLayoutChildIn(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof CollapsingToolbarLayout) {
                return (CollapsingToolbarLayout) child;
            } else if (child instanceof ViewGroup) {
                return findCollapsingToolbarLayoutChildIn((ViewGroup) child);
            }
        }
        return null;
    }

    private static View findFirstParentLayoutOfClass(View view, Class parentClass) {
        ViewParent parent = new FrameLayout(view.getContext());
        ViewParent incrementView = null;
        int i = 0;
        while (parent != null && !(parent.getClass() == parentClass)) {
            if (i == 0) {
                parent = findParent(view);
            } else {
                parent = findParent(incrementView);
            }
            incrementView = parent;
            i++;
        }
        return (View) parent;
    }

    private static ViewParent findParent(View view) {
        return view.getParent();
    }

    private static ViewParent findParent(ViewParent view) {
        return view.getParent();
    }
}

