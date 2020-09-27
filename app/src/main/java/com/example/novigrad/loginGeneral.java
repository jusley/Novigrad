package com.example.novigrad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        // when login as employee button is clicked
        mEmploylogBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(loginGeneral.this, emplog.class));
            }
        });

        // when login as client button is clicked
        mClientBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(loginGeneral.this, clientlog.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}