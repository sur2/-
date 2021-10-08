package com.example.class_8c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView ivPost = findViewById(R.id.iv_post);

        Intent intent = getIntent();
        Bitmap recvBitmap = intent.getParcelableExtra("photo");
        ivPost.setImageBitmap(recvBitmap);

//        Uri photoUri = intent.getData();
//        ivPost.setImageURI(photoUri);
    }
}