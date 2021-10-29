package customscrollactions.azimolabs.com.customscrollactions.ui.presenter;

import customscrollactions.azimolabs.com.customscrollactions.ui.CoordinatorLayoutActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.NestedScrollViewActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.NormalScrollViewActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.WelcomeScreenActivity;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class WelcomeScreenPresenter {

    private WelcomeScreenActivity view;

    public WelcomeScreenPresenter(WelcomeScreenActivity view) {
        this.view = view;
    }

    public void enterCoordinatorLayoutScreen() {
        CoordinatorLayoutActivity.openActivity(view);
    }

    public void enterNestedScrollView() {
        NestedScrollViewActivity.openActivity(view);
    }

    public void enterNormalScrollView() {
        NormalScrollViewActivity.openActivity(view);
    }
}
