package customscrollactions.azimolabs.com.customscrollactions.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import customscrollactions.azimolabs.com.customscrollactions.R;
import customscrollactions.azimolabs.com.customscrollactions.ui.presenter.WelcomeScreenPresenter;

public class WelcomeScreenActivity extends Activity {

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
        btnCoordinatorLayoutActivity.setOnClickListener(v -> welcomeScreenPresenter.enterCoordinatorLayoutScreen());
        btnNestedScrollViewActivity = (Button) findViewById(R.id.btn_nested_scroll_view_activity);
        btnNestedScrollViewActivity.setOnClickListener(v -> welcomeScreenPresenter.enterNestedScrollView());
    }

    private void setupPresenter() {
        welcomeScreenPresenter = new WelcomeScreenPresenter(this);
    }
}
