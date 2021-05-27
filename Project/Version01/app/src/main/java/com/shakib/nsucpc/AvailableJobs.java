package com.shakib.nsucpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AvailableJobs extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;

    private List<DataSet> dataSetList;
    private  CustomAdapter customAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_jobs);

        databaseReference = FirebaseDatabase.getInstance().getReference("JOBS");
        dataSetList= new ArrayList<>();
        customAdapter = new CustomAdapter(AvailableJobs.this,dataSetList);

        listView = findViewById(R.id.listviewID);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String key = ((TextView) view.findViewById(R.id.showJobTitleID)).getText().toString();
                String key2 = ((TextView) view.findViewById(R.id.jobtypeID)).getText().toString();
                String key3 = ((TextView) view.findViewById(R.id.locationViewID)).getText().toString();
                String key4 = ((TextView) view.findViewById(R.id.salaryViewID)).getText().toString();
                String key5 = ((TextView) view.findViewById(R.id.deadlineViewID)).getText().toString();
                String key6 = ((TextView) view.findViewById(R.id.interviewpreviewID)).getText().toString();
                String key7 = ((TextView) view.findViewById(R.id.jobInformationpreviewID)).getText().toString();
                String key8 = ((TextView) view.findViewById(R.id.otherBenefitpreviewID)).getText().toString();




                Toast.makeText(getApplicationContext(),key, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AvailableJobs.this, fullJobPreview.class);
                intent.putExtra("jobtitle",key);
                intent.putExtra("jobtype",key2);
                intent.putExtra("jobsalary",key4);
                intent.putExtra("joblocation",key3);
                intent.putExtra("interview",key6);
                intent.putExtra("deadline",key5);
                intent.putExtra("information",key7);
                intent.putExtra("otherbenefits",key8);


                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSetList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    DataSet dataSet = dataSnapshot1.getValue(DataSet.class);
//                    String myParentKey = dataSnapshot1.getKey().toString();
                    dataSetList.add(dataSet);
                }
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}