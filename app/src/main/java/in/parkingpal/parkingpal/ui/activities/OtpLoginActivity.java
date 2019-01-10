package in.parkingpal.parkingpal.ui.activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import in.parkingpal.parkingpal.R;


public class OtpLoginActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    int timeValue = 20;
    int coinValue = 0;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_login);


        Intent intent = getIntent();
        String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.txt_otpScreeen2);
        textView.setText(message);


    }


        /*
         Submit button to go in the main activity.
         */
    public void submitOtp(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    /*
     Intent for UpButton
     */
    public void upButtonCalled(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}

