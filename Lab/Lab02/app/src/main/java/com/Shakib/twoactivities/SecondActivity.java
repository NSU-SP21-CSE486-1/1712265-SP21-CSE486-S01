package com.Shakib.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.Shakib.twoactivities.extra.REPLY";
    private EditText mReply;
    private Button RICE;
    private Button CHEESE;
    private Button APPLE;
    private Button MANGO;



    private static final String LOG_TAG = SecondActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();


        RICE = findViewById(R.id.riceID);
        CHEESE = findViewById(R.id.cheeseID);
        APPLE = findViewById(R.id.appleID);
        MANGO = findViewById(R.id.mangoID);

//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView textView = findViewById(R.id.text_message);
//        textView.setText(message);
        mReply = findViewById(R.id.editText_second);


        RICE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
                String message = "RICE";

                intent.putExtra(EXTRA_REPLY, message);
               setResult(RESULT_OK, intent);
               finish();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }




//    public void returnReply(View view) {
//        //String reply = mReply.getText().toString();
//
//
//        Intent replyIntent = new Intent();
//        replyIntent.putExtra(EXTRA_REPLY, reply);
//        setResult(RESULT_OK, replyIntent);
//        finish();
//
//        Log.d(LOG_TAG, "End SecondActivity");
//
//    }
}