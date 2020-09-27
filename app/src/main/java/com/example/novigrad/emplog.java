package com.example.novigrad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class emplog extends AppCompatActivity {
    EditText mEmailet, mPasswordet;
    Button mloginbtn;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplog);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("logged as employee");

        firebaseAuth = FirebaseAuth.getInstance();

        mEmailet = findViewById(R.id.epmail_Et);
        mPasswordet = findViewById(R.id.empassword_Et);
        mAuth = FirebaseAuth.getInstance();
        mloginbtn = findViewById(R.id.emplog);

        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmailet.getText().toString().trim();
                String password = mPasswordet.getText().toString().trim();
               if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                   mEmailet.setError("invalid email");
                   mEmailet.setFocusable(true);
               }
               else{
                   loginUser(email,password);
               }
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(" Logging in, please wait...");
    }
    private void loginUser(String email, String password){
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(emplog.this,employeeprofile.class));

                        } else {
                            progressDialog.dismiss();
                            // If sign in fails, display a message to the user
                            Toast.makeText(emplog.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        //
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(emplog.this," "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}