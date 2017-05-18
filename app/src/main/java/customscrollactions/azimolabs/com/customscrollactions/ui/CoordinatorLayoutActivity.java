package customscrollactions.azimolabs.com.customscrollactions.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import customscrollactions.azimolabs.com.customscrollactions.R;
import customscrollactions.azimolabs.com.customscrollactions.data.MockDataRepository;
import customscrollactions.azimolabs.com.customscrollactions.ui.presenter.CoordinatorLayoutActivityPresenter;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {

    TextView tvText1;
    TextView tvText2;
    TextView tvText3;
    TextView tvText4;
    TextView tvText5;
    TextView tvText6;
    TextView tvText7;
    TextView tvText8;
    TextView tvText9;
    TextView tvText10;
    TextView tvText11;
    TextView tvText12;
    TextView tvText13;
    TextView tvText14;
    TextView tvText15;
    TextView tvText16;
    TextView tvText17;
    TextView tvText18;
    TextView tvText19;
    TextView tvText20;

    CoordinatorLayoutActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        setupPresenter();
        bindViews();
    }

    private void setupPresenter() {
        MockDataRepository mockDataRepository = new MockDataRepository();
        presenter = new CoordinatorLayoutActivityPresenter(this, mockDataRepository);
    }

    private void bindViews() {
        tvText1 = (TextView) findViewById(R.id.tvText1);
        tvText2 = (TextView) findViewById(R.id.tvText2);
        tvText3 = (TextView) findViewById(R.id.tvText3);
        tvText4 = (TextView) findViewById(R.id.tvText4);
        tvText5 = (TextView) findViewById(R.id.tvText5);
        tvText6 = (TextView) findViewById(R.id.tvText6);
        tvText7 = (TextView) findViewById(R.id.tvText7);
        tvText8 = (TextView) findViewById(R.id.tvText8);
        tvText9 = (TextView) findViewById(R.id.tvText9);
        tvText10 = (TextView) findViewById(R.id.tvText10);
        tvText11 = (TextView) findViewById(R.id.tvText11);
        tvText12 = (TextView) findViewById(R.id.tvText12);
        tvText13 = (TextView) findViewById(R.id.tvText13);
        tvText14 = (TextView) findViewById(R.id.tvText14);
        tvText15 = (TextView) findViewById(R.id.tvText15);
        tvText16 = (TextView) findViewById(R.id.tvText16);
        tvText17 = (TextView) findViewById(R.id.tvText17);
        tvText18 = (TextView) findViewById(R.id.tvText18);
        tvText19 = (TextView) findViewById(R.id.tvText19);
        tvText20 = (TextView) findViewById(R.id.tvText20);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.init();
        presenter.fillView();
    }

    public void updateTextView1(String text) {
        tvText1.setText(text);
    }

    public void updateTextView2(String text) {
        tvText2.setText(text);
    }

    public void updateTextView3(String text) {
        tvText3.setText(text);
    }

    public void updateTextView4(String text) {
        tvText4.setText(text);
    }

    public void updateTextView5(String text) {
        tvText5.setText(text);
    }

    public void updateTextView6(String text) {
        tvText6.setText(text);
    }

    public void updateTextView7(String text) {
        tvText7.setText(text);
    }

    public void updateTextView8(String text) {
        tvText8.setText(text);
    }

    public void updateTextView9(String text) {
        tvText9.setText(text);
    }

    public void updateTextView10(String text) {
        tvText10.setText(text);
    }

    public void updateTextView11(String text) {
        tvText11.setText(text);
    }

    public void updateTextView12(String text) {
        tvText12.setText(text);
    }

    public void updateTextView13(String text) {
        tvText13.setText(text);
    }

    public void updateTextView14(String text) {
        tvText14.setText(text);
    }

    public void updateTextView15(String text) {
        tvText15.setText(text);
    }

    public void updateTextView16(String text) {
        tvText16.setText(text);
    }

    public void updateTextView17(String text) {
        tvText17.setText(text);
    }

    public void updateTextView18(String text) {
        tvText18.setText(text);
    }

    public void updateTextView19(String text) {
        tvText19.setText(text);
    }

    public void updateTextView20(String text) {
        tvText20.setText(text);
    }
}
