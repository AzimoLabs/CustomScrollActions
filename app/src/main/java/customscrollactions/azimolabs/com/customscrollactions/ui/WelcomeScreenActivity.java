package customscrollactions.azimolabs.com.customscrollactions.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import customscrollactions.azimolabs.com.customscrollactions.R;
import customscrollactions.azimolabs.com.customscrollactions.ui.navigation.WelcomeScreenNavigator;
import customscrollactions.azimolabs.com.customscrollactions.ui.presenter.WelcomeScreenPresenter;

public class WelcomeScreenActivity extends AppCompatActivity {

    Button btnCoordinatorLayoutActivity;
    Button btnNestedScrollViewActivity;

    WelcomeScreenPresenter welcomeScreenPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        bindViews();
        setupPresenter();
    }

    private void bindViews() {
        btnCoordinatorLayoutActivity = (Button) findViewById(R.id.btn_coordinator_layout_activity);
        btnCoordinatorLayoutActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeScreenPresenter.onBtnCoordinatorLayoutActivityClicked();
            }
        });
        btnNestedScrollViewActivity = (Button) findViewById(R.id.btn_nested_scroll_view_activity);
        btnNestedScrollViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeScreenPresenter.onBtnNestedScrollViewActivity();
            }
        });
    }

    private void setupPresenter() {
        WelcomeScreenNavigator navigator = new WelcomeScreenNavigator(this);
        welcomeScreenPresenter = new WelcomeScreenPresenter(this, navigator);
    }
}
