package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditeProfile extends AppCompatActivity {
    private TextView currentPassword, EditHappy, EditRelax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_profile);
        currentPassword=(TextView) findViewById(R.id.textViewPassword);
        EditHappy=(TextView) findViewById(R.id.textViewEditHappy);
        EditRelax=(TextView) findViewById(R.id.textVieweditrelax);
        currentPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCurrentPasswordPage();
            }
        });
        EditHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditHappyPage();
            }
        });
        EditRelax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditRelaxPage();
            }
        });
    }
    public void openCurrentPasswordPage(){
        Intent intent = new Intent (this, changePassword.class);
        startActivity(intent);
    }
    public void openEditHappyPage(){
        Intent intent = new Intent (this, EditeHappyActivities.class);
        startActivity(intent);
    }
    public void openEditRelaxPage(){
        Intent intent = new Intent (this, EditRelaxActivities.class);
        startActivity(intent);
    }
}