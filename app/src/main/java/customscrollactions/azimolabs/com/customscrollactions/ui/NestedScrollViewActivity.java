package customscrollactions.azimolabs.com.customscrollactions.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import customscrollactions.azimolabs.com.customscrollactions.R;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class NestedScrollViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested);
    }

    public static void openActivity(Activity activity) {
        Intent intent = new Intent(activity, NestedScrollViewActivity.class);
        activity.startActivity(intent);
    }

}
