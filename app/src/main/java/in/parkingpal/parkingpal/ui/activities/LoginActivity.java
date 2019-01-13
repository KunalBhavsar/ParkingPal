package in.parkingpal.parkingpal.ui.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import in.parkingpal.parkingpal.R;
import in.parkingpal.parkingpal.ui.adapters.SliderAdapter;


public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "in.parkingpal.parkingpal.MESSAGE";


    private ViewPager mslideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mslideViewPager = findViewById(R.id.viewPager);
        mDotLayout = findViewById(R.id.dotsLayout);

        sliderAdapter = new SliderAdapter(this);
        mslideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mslideViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorBlue));
        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void getOtp(View view) {
        Intent intent = new Intent(LoginActivity.this, OtpLoginActivity.class);
        //TODO: Variable name should be edtMobile or mobileEditText
        EditText editText = findViewById(R.id.editText);
        //TODO: Variable name should be mobile
        String message = editText.getText().toString();
        //TODO: add validation of mobile number

        /*
            TODO: create an interface called as constants and declare all your constants as string in that interface
            so that you can refer that in any activity
            I have already created constant file in utils package with constant INTENT_EXTRA_MOBILE
            use that constant instead of EXTRA_MESSAGE
         */
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}

