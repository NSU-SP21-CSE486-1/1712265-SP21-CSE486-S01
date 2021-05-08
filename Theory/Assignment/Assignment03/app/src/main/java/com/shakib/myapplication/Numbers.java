package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers extends AppCompatActivity {

    private ImageView imageview;
    private EditText number;
    private EditText nidNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

         number = findViewById(R.id.editTextPhone);
         nidNumber = findViewById(R.id.nidNumberId);
         imageview = findViewById(R.id.imageViewnext);



        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( validMobile(nidNumber.getText().toString())){

                }
                else {

                    nidNumber.setError("Invalid Mobile Number");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        nidNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( validMobile(nidNumber.getText().toString())){

                }
                else {

                    nidNumber.setError("Invalid NID Number");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    boolean validMobile (String input){
    Pattern p = Pattern.compile("[0-0][1-1][0-9]{9}");
        Matcher m = p.matcher(input);
        return m.matches();
    }

    boolean validNidNumber (String input){
        Pattern p = Pattern.compile("[0-9]{10}");
        Matcher m = p.matcher(input);
        return m.matches();
    }

}