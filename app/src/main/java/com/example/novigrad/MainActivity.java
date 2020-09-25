package com.example.novigrad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mRegisterBtn, mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("NOVIGRAD");

        mLoginBtn = findViewById(R.id.login_Et);
        mRegisterBtn = findViewById(R.id.register_Et);

        //when login button is clicked
        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              startActivity(new Intent(MainActivity.this, loginGeneral.class));
            }
        });

        // when register button is clicked
        mRegisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });

    }
}