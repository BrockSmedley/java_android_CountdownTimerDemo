package com.brocksmedley.countdowntimerdemo;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    CountDownTimer countDownTimer;
    Boolean isTimerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
    }

    public void OnClick(View view){
        if (countDownTimer == null || !isTimerRunning) {
            isTimerRunning = true;
            countDownTimer = newTimer(5000, 500);
            countDownTimer.start();
        }
    }

    //helper function to return a timer that hooks up to our TextView
    private CountDownTimer newTimer(final int durationInMillis, final int interval){
        return new CountDownTimer(durationInMillis, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished%1000 > 500 || millisUntilFinished > (durationInMillis - interval)) {
                    int outputTime = Math.round(millisUntilFinished * 0.001f);
                    textView.setText(toString().valueOf(outputTime));
                }
            }

            @Override
            public void onFinish() {
                textView.setText("Finished");
                isTimerRunning = false;
            }
        };
    }
}
