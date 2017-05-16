package customscrollactions.azimolabs.com.customscrollactions.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import customscrollactions.azimolabs.com.customscrollactions.R;
import customscrollactions.azimolabs.com.customscrollactions.ui.presenter.NestedScrollViewActivityPresenter;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class NestedScrollViewActivity extends AppCompatActivity {

    NestedScrollViewActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested);

        setupPresenter();
    }

    private void setupPresenter() {
        presenter = new NestedScrollViewActivityPresenter(this);
    }
}
