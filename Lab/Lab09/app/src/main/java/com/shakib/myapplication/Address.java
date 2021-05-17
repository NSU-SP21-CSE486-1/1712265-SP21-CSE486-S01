package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class Address extends AppCompatActivity {

    private DatePicker datePicker;
    private Button selectButton;
    private TextView currentDate;

    private ImageView imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        datePicker = findViewById(R.id.datePickerId);
        currentDate = findViewById(R.id.currentDateTextViewID);


        currentDate.setText(currentDateGenerator());

//        selectButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                currentDate.setText(currentDateGenerator());
//            }
//        });




        imageview= findViewById(R.id.imageViewnext);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Address.this, Numbers.class);
                startActivity(intent);

            }
        });



    }



        String currentDateGenerator(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CurrentDate: ");
        stringBuilder.append(datePicker.getDayOfMonth()+"/");
            stringBuilder.append(datePicker.getMonth()+"/");
            stringBuilder.append(datePicker.getYear());

            return stringBuilder.toString();
        }




}