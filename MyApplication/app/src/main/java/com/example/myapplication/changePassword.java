package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class changePassword extends AppCompatActivity {
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        next=(Button) findViewById(R.id.buttonNextToChangePassword);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPasswordPage();
            }
        });
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Back");
    }
    public void openPasswordPage(){
        Intent intent = new Intent (this, passwordPage.class);
        startActivity(intent);
    }
}