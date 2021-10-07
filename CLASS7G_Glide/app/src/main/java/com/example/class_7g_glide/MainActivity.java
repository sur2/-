package com.example.class_7g_glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView ivPlanche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlanche = findViewById(R.id.iv_planche);

        findViewById(R.id.btn_start).setOnClickListener(v -> {
            startLoadingPlancheImage();
        });
    }

    private void startLoadingPlancheImage() {
        String url = "https://w.namu.la/s/2127962e9902ab8e340dc26bf1ed4995ff35427edcdaf57f150daf6a573a005add89290adbfd0eaee4ad92d4267db9bcd71b49e8b0aa2390ead462413297f2af355b8df1ddb82e572cafb24bfd3a02302168034b0a2fa2cd381fbcf272a7e0b4b45b5da60e0d315179cc620a8b158151";
        Glide.with(this).load(url).into(ivPlanche);
    }
}