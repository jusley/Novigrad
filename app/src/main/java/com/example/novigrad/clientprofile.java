package com.example.novigrad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class clientprofile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientprofile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("logged in as client");
    }
}