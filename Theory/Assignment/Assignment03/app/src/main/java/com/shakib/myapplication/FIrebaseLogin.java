package com.shakib.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class FIrebaseLogin extends AppCompatActivity implements View.OnClickListener {
    private EditText singinEmail;
    private EditText singinPassword;
    private Button singinButton;
    private TextView singupTextview;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_irebase_login);
        this.setTitle("Firebase Login");

        mAuth = FirebaseAuth.getInstance();

        singinEmail = findViewById(R.id.singInEmailId);
        singinPassword = findViewById(R.id.signInPasswordID);
        singinButton = findViewById(R.id.sinInButtonID);
        singupTextview = findViewById(R.id.signUpTextViewID);

        progressBar = findViewById(R.id.progressbarID);

        singupTextview.setOnClickListener(this);
        singinButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sinInButtonID:
                userLogin();
            break;


            case R.id.signUpTextViewID:
                Intent intent = new Intent(getApplicationContext(), FirebaseSignup.class);
                startActivity(intent);

            break;
        }


    }

    private void userLogin() {
        String email = singinEmail.getText().toString().trim();

        String password = singinPassword.getText().toString().trim();

        if(email.isEmpty())
        {
            singinEmail.setError("Enter an email address");
            singinEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            singinEmail.setError("Enter a valid email address");
            singinEmail.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            singinPassword.setError("Enter a password");
            singinPassword.requestFocus();
            return;
        }

        if(password.length()< 4 )
        {
            singinPassword.setError("Password too short !! ");
            singinPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful())
                {
                   Intent intent = new Intent(getApplicationContext(),StudentList.class);
                   startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Unsuccesfull",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}