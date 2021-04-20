package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] deptNames;
    private Spinner spinnerDeptNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deptNames = getResources().getStringArray(R.array.spinnerDeptName);
        spinnerDeptNames = findViewById(R.id.spinnerDeptNameId);

        ArrayAdapter<String>deptNameAdapter = new ArrayAdapter<String>(this,R.layout.spinnerview,R.id.SpinnerTextView,  deptNames);
        spinnerDeptNames.setAdapter(deptNameAdapter);
    }



    }
