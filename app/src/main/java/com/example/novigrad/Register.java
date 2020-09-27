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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register<ProgressDialog> extends AppCompatActivity {

    EditText mEmailEt, mPasswordEt, mFirstnameEt, mLastnameEt, mPhonenumEt, mRoleEt;
    Button mregisterBTN;
    private FirebaseAuth mAuth;
    DatabaseReference ref;

    android.app.ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Create Account");

        mEmailEt = findViewById(R.id.email_Et);
        mPasswordEt = findViewById(R.id.password_Et);
        mFirstnameEt = findViewById(R.id.firstname_Et);
        mLastnameEt = findViewById(R.id.lastname_Et);
        mPhonenumEt = findViewById(R.id.phonenum_Et);
        mRoleEt = findViewById(R.id.role_Et);

        mAuth = FirebaseAuth.getInstance();

//        ref = FirebaseDatabase.getInstance().getReference().child("user");

        mregisterBTN = findViewById(R.id.register_Et);
        progressDialog = new android.app.ProgressDialog(this);
        progressDialog.setMessage("Registering user...");

        mregisterBTN.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                String email = mEmailEt.getText().toString().trim();
                String password = mPasswordEt.getText().toString().trim();
                String Firstnm = mFirstnameEt.getText().toString().trim();
                String Lastnm = mLastnameEt.getText().toString().trim();
                String role = mRoleEt.getText().toString().trim();
                String phonenum = mPhonenumEt.getText().toString().trim();

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    mEmailEt.setError("Invalid Email");
                    mEmailEt.setFocusable(true);
                }
                else if(password.length()<7){
                    mPasswordEt.setError("password length must be greater than 7");
                    mPasswordEt.setFocusable(true);
                }
                else{
                    registerUser(email,password,Firstnm,Lastnm,role,phonenum);
                }

            }
        });



    }

    private void registerUser(final String email, final String password, final String firstname, final String lastname, final String role, final String phonenum){

        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user nUser = new user(firstname,lastname,email,role,password);
                            FirebaseUser user = mAuth.getCurrentUser();
                            //FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(nUser);

                            Toast.makeText(Register.this,"Registered",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            if(role.toLowerCase().equals("employee")){
                                startActivity(new Intent(Register.this,employeeprofile.class));
                                finish();
                            }
                            else if(role.toLowerCase().equals("client")) {
                                startActivity(new Intent(Register.this, clientprofile.class));
                                finish();
                            }


                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.dismiss();

                            Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(Register.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}