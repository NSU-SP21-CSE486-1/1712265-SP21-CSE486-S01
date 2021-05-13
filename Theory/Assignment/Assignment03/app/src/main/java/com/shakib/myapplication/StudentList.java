package com.shakib.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentList extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<DataSet> dataSetList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        listView = findViewById(R.id.studentListID);

        dataSetList = new ArrayList<>();

        customAdapter = new CustomAdapter(StudentList.this,dataSetList);

        databaseReference = FirebaseDatabase.getInstance().getReference();



    }

    @Override
    protected void onStart() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot snapshot) {
                dataSetList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    DataSet dataSet = dataSnapshot.getValue(DataSet.class);
                    dataSetList.add(dataSet);

                }
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }


            public void onDataChange() {

            }


            public void onCancelled() {

            }
        });
        super.onStart();
    }
}