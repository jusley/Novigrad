package com.example.novigrad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class clientlog extends AppCompatActivity {
    EditText memailet, mpasswordet;
    Button mloginBtn;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlog);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("logged in as client");

        firebaseAuth = FirebaseAuth.getInstance();

        memailet = findViewById(R.id.cmail_Et);
        mpasswordet = findViewById(R.id.cpassword_ET);
        mAuth = FirebaseAuth.getInstance();
        mloginBtn = findViewById(R.id.clog_et);

        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = memailet.getText().toString().trim();
                String password = mpasswordet.getText().toString().trim();
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    memailet.setError("invalid email");
                    memailet.setFocusable(true);
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
                            startActivity(new Intent(clientlog.this,clientprofile.class));

                        } else {
                            progressDialog.dismiss();
                            // If sign in fails, display a message to the user
                            Toast.makeText(clientlog.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        //
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(clientlog.this," "+e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}