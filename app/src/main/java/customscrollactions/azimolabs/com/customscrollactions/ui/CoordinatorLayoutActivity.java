package customscrollactions.azimolabs.com.customscrollactions.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import customscrollactions.azimolabs.com.customscrollactions.R;
import customscrollactions.azimolabs.com.customscrollactions.ui.presenter.CoordinatorLayoutActivityPresenter;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    CoordinatorLayoutActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        setupPresenter();
    }

    private void setupPresenter() {
        presenter = new CoordinatorLayoutActivityPresenter(this);
    }
}
