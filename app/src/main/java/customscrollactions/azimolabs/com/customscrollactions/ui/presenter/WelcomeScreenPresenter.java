package customscrollactions.azimolabs.com.customscrollactions.ui.presenter;

import customscrollactions.azimolabs.com.customscrollactions.ui.WelcomeScreenActivity;
import customscrollactions.azimolabs.com.customscrollactions.ui.navigation.WelcomeScreenNavigator;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class WelcomeScreenPresenter {

    private WelcomeScreenActivity view;
    private WelcomeScreenNavigator navigator;

    public WelcomeScreenPresenter(WelcomeScreenActivity view,
                                  WelcomeScreenNavigator navigator) {
        this.view = view;
        this.navigator = navigator;
    }

    public void enterCoordinatorLayoutScreen() {
        navigator.navigateToCoordinatorLayoutActivity();
    }

    public void enterNestedScrollView() {
        navigator.navigateToNestedScrollViewActivity();
    }
}
