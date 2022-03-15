package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditeHappyActivities extends AppCompatActivity {
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_happy_activities);
        save=(Button) findViewById(R.id.buttonSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditeProfile();
            }
        });

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Back");
    }
    private void openEditeProfile() {
        Intent intent = new Intent(this, EditeProfile.class);
        startActivity(intent);
    }
}