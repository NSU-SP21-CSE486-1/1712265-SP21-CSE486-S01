package com.shakib.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
    private Button savedLoginButton;
    private TextView singupTextview;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    private CheckBox rememberMe;


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
        rememberMe = findViewById(R.id.checkBoxRemembermeID);
        savedLoginButton = findViewById(R.id.savedSingInButtonID);

        singupTextview.setOnClickListener(this);
        singinButton.setOnClickListener(this);
        savedLoginButton.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        StringBuilder stringBuilder = new StringBuilder();


        switch (v.getId()){
            case R.id.sinInButtonID:
                userLogin();
            break;


            case R.id.signUpTextViewID:
                Intent intent = new Intent(getApplicationContext(), FirebaseSignup.class);
                startActivity(intent);

            break;

            case R.id.savedSingInButtonID:
                SharedPreferences sharedPreferences = getSharedPreferences("UserDetails",Context.MODE_PRIVATE);
                if (sharedPreferences.contains("emailKey") && sharedPreferences.contains("passwordKey")){
                    String userEmail = sharedPreferences.getString("emailKey","Data not Found");
                    String userId = sharedPreferences.getString("passwordKey","Data not Found");
                    singinEmail.setText(userEmail);
                    singinPassword.setText(userId);

                }

        }


    }

    private void userLogin() {
        String email = singinEmail.getText().toString().trim();

        String password = singinPassword.getText().toString().trim();

        //Saving data Using SharedPreference.

        if (rememberMe.isChecked()){
            String emailRememberme = singinEmail.getText().toString().trim();

            String passwordRememberme = singinPassword.getText().toString().trim();
            SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("emailKey",emailRememberme);
            editor.putString("passwordKey",password);
            editor.commit();
        }
        else {}



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