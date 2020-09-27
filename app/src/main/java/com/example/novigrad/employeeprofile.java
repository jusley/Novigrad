package com.example.novigrad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class employeeprofile extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextView profileV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeeprofile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Employee Profile");
        firebaseAuth = FirebaseAuth.getInstance();
        profileV = findViewById(R.id.emprofile);

    }
    private void Display(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            profileV.setText(user.getUid());
        }

    }
}