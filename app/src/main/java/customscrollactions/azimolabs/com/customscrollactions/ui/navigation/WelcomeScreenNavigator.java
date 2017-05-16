package customscrollactions.azimolabs.com.customscrollactions.ui.navigation;

import android.content.Intent;

import customscrollactions.azimolabs.com.customscrollactions.ui.CoordinatorLayoutActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.NestedScrollViewActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.WelcomeScreenActivity;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class WelcomeScreenNavigator {

    private WelcomeScreenActivity activity;

    public WelcomeScreenNavigator(WelcomeScreenActivity activity) {
        this.activity = activity;
    }

    public void navigateToCoordinatorLayoutActivity() {
        Intent intent = new Intent(this.activity, CoordinatorLayoutActivity.class);
        this.activity.startActivity(intent);
    }

    public void navigateToNestedScrollViewActivity() {
        Intent intent = new Intent(this.activity, NestedScrollViewActivity.class);
        this.activity.startActivity(intent);
    }
}
