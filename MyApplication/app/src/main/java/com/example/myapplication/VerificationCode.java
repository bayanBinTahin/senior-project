package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class VerificationCode extends AppCompatActivity {
    private TextView countdown, resend, reciveCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
        countdown= (TextView)findViewById(R.id.textCountdownVerification);
        resend= (TextView)findViewById(R.id.textResendVerification);
        reciveCode= (TextView)findViewById(R.id.textReciveCodeVerification);

        countDown();
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reciveCode.setText("");
                resend.setText("");
                countDown();
            }
        });
    }
    public void countDown(){
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                countdown.setText(millisUntilFinished / 1000 + "s");
            }
            public void onFinish() {
                countdown.setText("");
                reciveCode.setText("Didn`t recive a code !");
                resend.setText("Resend");
            }
        }.start();
    }
}