package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText nsuidEditText;

    private ImageView imageview;
    private Button firebaseConnectButton;
    private Button submitButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    DataSet dataset ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameId);
        nsuidEditText = findViewById(R.id.editTextNsuId);

        imageview= findViewById(R.id.imageViewnext);

        submitButton= findViewById(R.id.submitButtonID);
        firebaseConnectButton = findViewById(R.id.firebsaeConnectButtonId);





        //String name = nameEditText.getText().toString().trim();

       // String value = nameEditText.getText().toString().trim();

        //editor.commit();





        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // saveData();

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("students");

                String name = nameEditText.getText().toString();
                 String  id =  nsuidEditText.getText().toString();
                String schoolNameSpinner = nameEditText.getText().toString();
                String  deptNameSpinner =  nsuidEditText.getText().toString();

         //  DataSet DatasetForStudent = new DataSet(name,id);
          // reference.child(id).setValue(DatasetForStudent);

            }
        });

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                SharedPreferences name = getSharedPreferences("nameKey", MODE_PRIVATE);
                SharedPreferences id = getSharedPreferences("idKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = name.edit();
                SharedPreferences.Editor editorid = id.edit();

                editor.putString("valueName", nameEditText.getText().toString());
                editor.putString("valueId", nsuidEditText.getText().toString());
                editor.apply();


                Intent intent = new Intent(MainActivity.this, SchoolActivity.class);
                startActivity(intent);

            }
        });

        firebaseConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FIrebaseLogin.class);
                startActivity(intent);

            }
        });



        }


}
