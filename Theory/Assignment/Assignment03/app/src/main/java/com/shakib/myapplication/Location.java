package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Location extends AppCompatActivity {


    private Button imageview;

   DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        imageview= findViewById(R.id.imageViewnextID);

//
//        SharedPreferences username = getSharedPreferences("nameKey", MODE_PRIVATE);
//        SharedPreferences userid = getSharedPreferences("idKey", MODE_PRIVATE);
//        SharedPreferences name = getSharedPreferences("schoolNameKey", MODE_PRIVATE);
//        SharedPreferences id = getSharedPreferences("deptNameKey", MODE_PRIVATE);
//
//
//
//
//
//
//
//
//        String valueName = username.getString("valueName","");
//        String valueId = username.getString("valueId","");
//        String valueSchool = name.getString("schoolName","");
//        String valueDept = name.getString("DeptName","");
//
//
//
////        Toast.makeText(getApplicationContext(),valueName.toString(),Toast.LENGTH_SHORT).show();
////        Toast.makeText(getApplicationContext(),valueId.toString(),Toast.LENGTH_SHORT).show();
////        Toast.makeText(getApplicationContext(),valueSchool.toString(),Toast.LENGTH_SHORT).show();
////        Toast.makeText(getApplicationContext(),valueDept.toString(),Toast.LENGTH_SHORT).show();
//
//
//        databaseReference = FirebaseDatabase.getInstance().getReference();
//



        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Location.this, MainActivity.class);
                startActivity(intent);


                SharedPreferences username = getSharedPreferences("nameKey", MODE_PRIVATE);
                SharedPreferences userid = getSharedPreferences("idKey", MODE_PRIVATE);
                SharedPreferences name = getSharedPreferences("schoolNameKey", MODE_PRIVATE);
                SharedPreferences id = getSharedPreferences("deptNameKey", MODE_PRIVATE);








                String valueName = username.getString("valueName","");
                String valueId = username.getString("valueId","");
                String valueSchool = name.getString("schoolName","");
                String valueDept = name.getString("DeptName","");





                databaseReference = FirebaseDatabase.getInstance().getReference();

                DataSet dataSet = new DataSet(valueName,valueId,valueSchool,valueDept);
                databaseReference.child(valueId).setValue(dataSet);


                Toast.makeText(getApplicationContext(),"Submit Complete!!",Toast.LENGTH_SHORT).show();

////
////        Toast.makeText(getApplicationContext(),valueName.toString(),Toast.LENGTH_SHORT).show();
////        Toast.makeText(getApplicationContext(),valueId.toString(),Toast.LENGTH_SHORT).show();
////        Toast.makeText(getApplicationContext(),valueSchool.toString(),Toast.LENGTH_SHORT).show();
////        Toast.makeText(getApplicationContext(),valueDept.toString(),Toast.LENGTH_SHORT).show();




            }
        });


    }






}