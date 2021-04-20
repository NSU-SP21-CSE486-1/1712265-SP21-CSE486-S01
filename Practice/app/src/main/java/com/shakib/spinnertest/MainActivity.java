package com.shakib.spinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner deptNames;
    String[] spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         spinner = getResources().getStringArray(R.array.DeptName);
         deptNames = findViewById(R.id.spinnerId);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinnerview,R.id.SpinnerTextView,spinner);
        deptNames.setAdapter(spinnerAdapter);


    }
}