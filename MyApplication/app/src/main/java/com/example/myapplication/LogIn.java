package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
    private TextView forget, create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create=findViewById(R.id.createAccountLogIn);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateAccount();
            }
        });
        forget = findViewById(R.id.textForgetPasswordLogIn);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForgetPassword();
            }
        });
    }
    public void openForgetPassword(){
        Intent intent = new Intent(this, ForgetPassword.class);
        startActivity(intent);
    }
    public void openCreateAccount(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}