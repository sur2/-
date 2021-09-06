package com.example.class_4g;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

// 4-G View
public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.iv_like).setOnClickListener(this);
        findViewById(R.id.iv_share).setOnClickListener(this);

        findViewById(R.id.iv_photo).setOnClickListener(this);
        findViewById(R.id.iv_photo).setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_like:
                Toast.makeText(MainActivity.this, "Like!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.iv_share:
                Toast.makeText(MainActivity.this, "Share~", Toast.LENGTH_SHORT).show();
                break;

            case R.id.iv_photo:
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(MainActivity.this, "Touch Up.", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Toast.makeText(MainActivity.this, "Touch Down.", Toast.LENGTH_SHORT).show();
                break;
        }
        // 현재 메서드에서 콜백을 종료 할 지 결정(false: 다음 콜벡 호출 / true: 다음 콜백 호출 불가)
        return true;
    }
}