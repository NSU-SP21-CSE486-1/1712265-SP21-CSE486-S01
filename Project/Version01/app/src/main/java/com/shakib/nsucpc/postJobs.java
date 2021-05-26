package com.shakib.nsucpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class postJobs extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{
    private Spinner jobType;
    private DatePicker deadlineDate;
    private DatePicker interviewDate;

    private Button submit;

    private EditText jobTitile;
    private EditText location;
    private EditText salary;
    private EditText jobInformation;
    private EditText otherBenefits;

    DatabaseReference databaseReference;


        String[] jobtypes = { "Full-Time", "Part-Time", "Inter"};

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_jobs);

        jobTitile= findViewById(R.id.jobTitleID);
        location= findViewById(R.id.jobLocationID);
        salary= findViewById(R.id.salaryID);
        jobInformation= findViewById(R.id.jobInformationID);
        otherBenefits= findViewById(R.id.otherBenefitID);
        deadlineDate= findViewById(R.id.deadlineDatePickerId);
        interviewDate= findViewById(R.id.interviewDatePickerId);
        jobType= findViewById(R.id.jobTypespinnerId);
        submit= findViewById(R.id.submitJobpostID);



            jobType.setOnItemSelectedListener(this);
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,jobtypes);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            jobType.setAdapter(aa);


            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String jobTitle = jobTitile.getText().toString();
                    String Location = location.getText().toString();
                    String Salary = salary.getText().toString();

                    String Information = jobInformation.getText().toString();
                    String Otherbenefits = otherBenefits.getText().toString();
                    String spinnervalue = jobType.getSelectedItem().toString();

//           int deadlinedate =  deadlineDate.getDayOfMonth();
//            int deadlinemonth =  deadlineDate.getMonth();
//            int deadlineyear =  deadlineDate.getYear();

                    StringBuilder stringBuilder = new StringBuilder();

                    stringBuilder.append(deadlineDate.getDayOfMonth()+"/");
                    stringBuilder.append(deadlineDate.getMonth()+"/");
                    stringBuilder.append(deadlineDate.getYear());

                    String Deadline= stringBuilder.toString();

//            int interviewdate =interviewDate.getDayOfMonth();
//            int interviewmonth= interviewDate.getMonth();
//            int interviewyear =  interviewDate.getYear();

                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(interviewDate.getDayOfMonth()+"/");
                    stringBuilder2.append(interviewDate.getMonth()+"/");
                    stringBuilder2.append(interviewDate.getYear());
                    String interview= stringBuilder2.toString();





                    databaseReference = FirebaseDatabase.getInstance().getReference("JOBS");


                    String Uniqekey = databaseReference.push().getKey();
//                    String jobTitle, String jobtype, String location, String salary, String deadline, String interviewdate, String jobinformation, String otherbenefits, String uniqekey

                        DataSet dataSet = new DataSet(jobTitle,spinnervalue,Location,Salary,Deadline,interview,Information , Otherbenefits , Uniqekey );
                    databaseReference.child(Uniqekey).setValue(dataSet);

                    Intent intent = new Intent(getApplicationContext(), adminOptions.class);
                    startActivity(intent);


                }
            });



    }







    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),jobtypes[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    String DeadlineDATE(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CurrentDate: ");
        stringBuilder.append(deadlineDate.getDayOfMonth()+"/");
        stringBuilder.append(deadlineDate.getMonth()+"/");
        stringBuilder.append(deadlineDate.getYear());

        return stringBuilder.toString();
    }

}
