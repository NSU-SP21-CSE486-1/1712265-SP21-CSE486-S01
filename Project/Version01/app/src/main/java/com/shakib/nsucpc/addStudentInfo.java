package com.shakib.nsucpc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addStudentInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private EditText singupEmail;
    private EditText singupPassword;
    private Button singupButton;
    private TextView singinTextview;

    private ProgressBar progressbar;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_info);

        singupEmail = findViewById(R.id.singUpEmailID);
        singupPassword = findViewById(R.id.singUpPasswordID);
        singupButton = findViewById(R.id.signUpButtonID);
        singinTextview = findViewById(R.id.signInTextViewID);


    singupButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            databaseReference = FirebaseDatabase.getInstance().getReference("Student");
            String Uniqekey = databaseReference.push().getKey();
            String email = singupEmail.getText().toString();
            String password = singupPassword.getText().toString();

            DataSet dataSet = new DataSet(email, password );
            databaseReference.child((Uniqekey)).setValue(dataSet);
            Intent intent = new Intent(getApplicationContext(), adminOptions.class);
            startActivity(intent);

        }
    });

}



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}