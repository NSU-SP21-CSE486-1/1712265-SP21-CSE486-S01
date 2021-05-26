package com.shakib.nsucpc;

import android.os.Bundle;
import android.widget.ListView;

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

        databaseReference = FirebaseDatabase.getInstance().getReference("Jobs");
        dataSetList= new ArrayList<>();
        customAdapter = new CustomAdapter(AvailableJobs.this,dataSetList);

        listView = findViewById(R.id.listviewID);
    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSetList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    DataSet dataSet = dataSnapshot1.getValue(DataSet.class);
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