package com.shakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SchoolActivity extends AppCompatActivity {

    private Spinner schoolNames , deptNames;
    private Spinner schoolNameSpinner , deptNamesSpinner;



       String schoolSpinnerValue, deptSpinnerValue;

    ArrayList<String> subCatagories = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter_schoolNames;


    ArrayList<String> arrayList_Economics, arrayList_Humanities, arrayList_Engineering, arrayList_health;
    ArrayAdapter<String> arrayAdapter_deptnames;

    private ImageView imageview;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        schoolNames = findViewById(R.id.spinnerId);
        deptNames = findViewById(R.id.spinnerDepartmentId);

        imageview= findViewById(R.id.imageViewnext);

        ArrayList<String> Catagories = new ArrayList<>();
        Catagories.add("School of Business and Economics");
        Catagories.add("School of Humanities and Social Science");
        Catagories.add("School of Engineering and Physical Science");
        Catagories.add("School of Health and Life Science");

        arrayAdapter_schoolNames= new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,Catagories);


        schoolNames.setAdapter(arrayAdapter_schoolNames);




//        Deptnames process starts(child Spinner)

        arrayList_Economics = new ArrayList<>();
        arrayList_Economics.add("Accounting & Finance");
        arrayList_Economics.add("Economics");
        arrayList_Economics.add("Managment");
        arrayList_Economics.add("Marketing & International Business");


        arrayList_Engineering = new ArrayList<>();
        arrayList_Engineering.add("Architecture");
        arrayList_Engineering.add("Civil & Environmental Engeneering");
        arrayList_Engineering.add("Electrical & Computer Engineering");
        arrayList_Engineering.add("Mathematics & Physics");

        arrayList_Humanities = new ArrayList<>();
        arrayList_Humanities.add("English & Modern Language");
        arrayList_Humanities.add("Political Science & Sociology");
        arrayList_Humanities.add("Law");

        arrayList_health = new ArrayList<>();
        arrayList_health.add("Biochemistry & Microbiology");
        arrayList_health.add("Environmental Science & Managment");
        arrayList_health.add("Public Health");


        schoolNames.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position== 0){
                    arrayAdapter_deptnames = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Economics);
                }
                if(position== 2){
                    arrayAdapter_deptnames = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Engineering);
                }
                if(position== 1){
                    arrayAdapter_deptnames = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Humanities);
                }
                if(position== 3){
                    arrayAdapter_deptnames = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_health);
                }




                deptNames.setAdapter(arrayAdapter_deptnames);
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //spinner.setSpinner(schoolNames.getSelectedItem().toString());

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("students");
                String schoolNameSpinner,deptNameSpinner;

                schoolSpinnerValue = schoolNames.getSelectedItem().toString();
                deptSpinnerValue = deptNames.getSelectedItem().toString();

                DataSet DatasetForStudent = new DataSet(schoolSpinnerValue,deptSpinnerValue);
                reference.child(schoolSpinnerValue).setValue(DatasetForStudent);

                Intent intent = new Intent( SchoolActivity.this,Address.class);
                startActivity(intent);



            }
        });







//
//        ArrayAdapter<String> adapter_1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Catagories);
//
//        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        schoolNames.setAdapter(adapter_1);
//
//        schoolNames.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if(adapterView.getItemAtPosition(i).equals("School of Business and Economics"))
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });




//        spinner = getResources().getStringArray(R.array.DeptName);
//        schoolNames = findViewById(R.id.spinnerId);
//
//        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinnerview,R.id.SpinnerTextView,spinner);
//        schoolNames.setAdapter(spinnerAdapter);



    }
}