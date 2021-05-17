package com.Shakib.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE =
            "com.Shakib.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;
    private TextView itemId1;
    private TextView itemId2;
    private TextView itemId3;
    private TextView itemId4;
    private TextView itemId5;
    private TextView itemId6;
    private TextView itemId7;private TextView itemId8;
    private TextView itemId9;
    private TextView itemId10;




    private Button addItemButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemId1 = findViewById(R.id.itemId1);
        itemId2 = findViewById(R.id.itemId2);
        itemId3 = findViewById(R.id.itemId3);
        itemId4 = findViewById(R.id.itemId4);
        itemId5 = findViewById(R.id.itemId5);
        itemId6 = findViewById(R.id.itemId6);
        itemId7 = findViewById(R.id.itemId7);
        itemId8 = findViewById(R.id.itemId8);
        itemId9 = findViewById(R.id.itemId9);



//        mReplyHeadTextView = findViewById(R.id.text_header_reply);
//        mReplyTextView = findViewById(R.id.text_message_reply);

        addItemButton = findViewById(R.id.addItemButtonID);

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");


        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
               startActivity(intent);
            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(LOG_TAG, "onPostResume");

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

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }




    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String intent =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);
                itemId2.setVisibility(View.VISIBLE);
                itemId2.setText(intent);
                itemId2.setVisibility(View.VISIBLE);
            }
        }
    }
}