package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PresentLocation extends AppCompatActivity {
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_location);
        imageview= findViewById(R.id.imageViewnext);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PresentLocation.this, Location.class);
                startActivity(intent);

            }
        });

    }
}