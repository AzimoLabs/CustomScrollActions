package customscrollactions.azimolabs.com.customscrollactions.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static customscrollactions.azimolabs.com.customscrollactions.utils.CustomScrollActions.scrollTo;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import customscrollactions.azimolabs.com.customscrollactions.R;
import customscrollactions.azimolabs.com.customscrollactions.ui.NestedScrollViewActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.NormalScrollViewActivity;

/**
 * Created by F1sherKK on 18/05/2017.
 */

@RunWith(AndroidJUnit4.class)
public class NormalScrollView_CustomScrollActionsTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(NormalScrollViewActivity.class);
    }

    @Test
    public void fallbackToNativeScroll() {
        onView(withId(R.id.tvText1))
                .perform(scrollTo())
                .check(matches(isCompletelyDisplayed()));

        onView(withId(R.id.tvText20))
                .perform(scrollTo())
                .check(matches(isCompletelyDisplayed()));
    }
}
