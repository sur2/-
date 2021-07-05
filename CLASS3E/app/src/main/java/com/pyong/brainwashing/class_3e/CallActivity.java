package com.pyong.brainwashing.class_3e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        String message = getIntent().getStringExtra("intent-message");
        Log.d("Toast", message);
        Toast.makeText(CallActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}