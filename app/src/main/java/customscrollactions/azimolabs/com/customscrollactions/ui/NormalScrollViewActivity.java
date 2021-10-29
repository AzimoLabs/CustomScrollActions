package customscrollactions.azimolabs.com.customscrollactions.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import customscrollactions.azimolabs.com.customscrollactions.R;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class NormalScrollViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }

    public static void openActivity(Activity activity) {
        Intent intent = new Intent(activity, NormalScrollViewActivity.class);
        activity.startActivity(intent);
    }
}
