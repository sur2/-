package com.example.class_6c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.class_6c.model.PostItem;
import com.example.class_6c.recyclerview.PostAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PostItem> listItem = new ArrayList<>();
        RecyclerView rvList = findViewById(R.id.rv_list);

        for (int i = 0; i < 10; i++) {
            PostItem item = new PostItem(10,
                    true,
                    "star",
                    "https://image.ytn.co.kr/general/jpg/2019/0923/201909232130264620_t.jpg",
                    "wow!");
            listItem.add(i, item);
        }

        for (PostItem item : listItem) {
            View v = View.inflate(this, R.layout.post_item, null);
            TextView tvUserName = v.findViewById(R.id.tv_userName);
            TextView tvPostText = v.findViewById(R.id.tv_postText);

            tvUserName.setText(item.getUserName());
            tvPostText.setText(item.getPostText());

        }

        PostAdapter adapter = new PostAdapter(this, listItem);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvList.setAdapter(adapter);
    }
}