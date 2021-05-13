package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Location extends AppCompatActivity {


    private ImageView imageview;

    DataSet dataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        imageview= findViewById(R.id.imageViewnext);


        SharedPreferences username = getSharedPreferences("nameKey", MODE_PRIVATE);
        SharedPreferences userid = getSharedPreferences("idKey", MODE_PRIVATE);
        SharedPreferences name = getSharedPreferences("schoolNameKey", MODE_PRIVATE);
        SharedPreferences id = getSharedPreferences("deptNameKey", MODE_PRIVATE);








        String valueName = username.getString("valueName","");
        String valueId = username.getString("valueId","");
        String valueSchool = name.getString("schoolName","");
        String valueDept = name.getString("DeptName","");



//        Toast.makeText(getApplicationContext(),valueName.toString(),Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),valueId.toString(),Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),valueSchool.toString(),Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),valueDept.toString(),Toast.LENGTH_SHORT).show();




        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Location.this, SchoolActivity.class);
                startActivity(intent);
//




            }
        });


    }
}