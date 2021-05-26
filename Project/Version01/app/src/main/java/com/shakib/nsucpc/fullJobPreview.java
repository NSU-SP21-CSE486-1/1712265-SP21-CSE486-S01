package com.shakib.nsucpc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class fullJobPreview extends AppCompatActivity {
    private TextView asd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_job_preview);

        asd = findViewById(R.id.add);
        Bundle extras = getIntent().getExtras();
        String userName;

        if (extras != null) {
            userName = extras.getString("name");
            // and get whatever type user account id is
        }
    }
}