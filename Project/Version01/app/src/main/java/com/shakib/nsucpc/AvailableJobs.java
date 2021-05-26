package com.shakib.nsucpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
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
    private EditText jobTitile;
    private TextView key;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_jobs);

        databaseReference = FirebaseDatabase.getInstance().getReference("JOBS");
        dataSetList= new ArrayList<>();
        customAdapter = new CustomAdapter(AvailableJobs.this,dataSetList);

        listView = findViewById(R.id.listviewID);

        key = findViewById(R.id.keyID);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String contactId = ((TextView) view.findViewById(R.id.keyID)).getText().toString();


                Toast.makeText(getApplicationContext(),contactId, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AvailableJobs.this, fullJobPreview.class);
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
                    String myParentKey = dataSnapshot1.getKey().toString();
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