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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText nsuidEditText;

    private ImageView imageview;
    private Button firebaseConnectButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameId);
        nsuidEditText = findViewById(R.id.editTextNsuId);

        imageview= findViewById(R.id.imageViewnext);
        firebaseConnectButton = findViewById(R.id.firebsaeConnectButtonId);





        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

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

    private void saveData() {
        String name = nameEditText.getText().toString();
        String  id =  nsuidEditText.getText().toString();

    }
}
