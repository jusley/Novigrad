package com.example.novigrad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class loginGeneral extends AppCompatActivity {

    Button mEmploylogBtn, mClientBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_general2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Log into your account");

        mEmploylogBtn = findViewById(R.id.employlog_Et);
        mClientBtn = findViewById(R.id.clientlog_Et);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}