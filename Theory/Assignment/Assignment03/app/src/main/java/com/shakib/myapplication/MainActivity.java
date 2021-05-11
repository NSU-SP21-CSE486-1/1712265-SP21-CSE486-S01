package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameId);
        nsuidEditText = findViewById(R.id.editTextNsuId);

        imageview= findViewById(R.id.imageViewnext);

        submitButton= findViewById(R.id.submitButtonID);
        firebaseConnectButton = findViewById(R.id.firebsaeConnectButtonId);




        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // saveData();

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("students");

                String name = nameEditText.getText().toString();
                 String  id =  nsuidEditText.getText().toString();

           DataSet DatasetForStudent = new DataSet(name,id);

            reference.child(id).setValue(DatasetForStudent);

            }
        });

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
