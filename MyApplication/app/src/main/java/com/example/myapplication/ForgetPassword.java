package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetPassword extends AppCompatActivity {
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        send=(Button) findViewById(R.id.buttonSendForgetPage);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVerificationCode();
            }
        });

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Back");
    }
    private void openVerificationCode() {
        Intent intent = new Intent(this, VerificationCode.class);
        startActivity(intent);
    }
}