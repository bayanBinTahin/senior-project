package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class passwordPage extends AppCompatActivity {
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_page);

        save=(Button) findViewById(R.id.buttonSaveToHome);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
            }
        });
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Back");
    }
    public void openHomePage(){
        Intent intent = new Intent (this, HomePage.class);
        startActivity(intent);
    }
}