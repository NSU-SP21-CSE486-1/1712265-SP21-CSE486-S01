package com.shakib.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseSignup extends AppCompatActivity implements View.OnClickListener {

    private EditText singupEmail;
    private EditText singupPassword;
    private Button singupButton;
    private TextView singinTextview;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_signup);
        this.setTitle("Firebase SignUp");

        mAuth = FirebaseAuth.getInstance();

        singupEmail = findViewById(R.id.singUpEmailID);
        singupPassword = findViewById(R.id.singUpPasswordID);
        singupButton = findViewById(R.id.signUpButtonID);
        singinTextview = findViewById(R.id.signInTextViewID);
        progressbar = findViewById(R.id.signupProgressbarID);

        singinTextview.setOnClickListener(this);
        singupButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUpButtonID:
                userRegister();
                break;


            case R.id.signInTextViewID:
                Intent intent = new Intent(FirebaseSignup.this, FIrebaseLogin.class);
                startActivity(intent);

                break;
        }
    }

    private void userRegister() {
        String email = singupEmail.getText().toString().trim();

        String password = singupPassword.getText().toString().trim();

        if(email.isEmpty())
        {
            singupEmail.setError("Enter an email address");
            singupEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            singupEmail.setError("Enter a valid email address");
            singupEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            singupPassword.setError("Enter a password");
            singupPassword.requestFocus();
            return;
        }

        if(password.length()< 4 )
        {
            singupPassword.setError("Password too short !! ");
            singupPassword.requestFocus();
            return;
        }
        progressbar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressbar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Register is successfull",Toast.LENGTH_SHORT).show();

                        } else {
                           if (task.getException() instanceof FirebaseAuthUserCollisionException)
                           {
                               Toast.makeText(getApplicationContext(),"User is already Registered ", Toast.LENGTH_SHORT).show();
                           }
                            else {
                               Toast.makeText(getApplicationContext(), "Register is not successfull", Toast.LENGTH_SHORT).show();
                           }
                        }

                        // ...
                    }
                });
    }
}