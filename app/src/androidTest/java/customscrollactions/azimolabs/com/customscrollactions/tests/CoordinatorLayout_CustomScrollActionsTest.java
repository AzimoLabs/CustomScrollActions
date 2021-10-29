package customscrollactions.azimolabs.com.customscrollactions.tests;

import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import customscrollactions.azimolabs.com.customscrollactions.R;
import customscrollactions.azimolabs.com.customscrollactions.ui.CoordinatorLayoutActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.NestedScrollViewActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static customscrollactions.azimolabs.com.customscrollactions.utils.CustomScrollActions.scrollTo;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

/**
 * Created by F1sherKK on 18/05/2017.
 */

@RunWith(AndroidJUnit4.class)
public class CoordinatorLayout_CustomScrollActionsTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(CoordinatorLayoutActivity.class);
    }

    @Test
    public void useCustomCoordinatorScrollAction() {
        onView(withId(R.id.tvText1))
                .perform(scrollTo())
                .check(matches(isCompletelyDisplayed()));

        onView(withId(R.id.tvText20))
                .perform(scrollTo())
                .check(matches(isCompletelyDisplayed()));
    }
}
