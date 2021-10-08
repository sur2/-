package com.example.class_8c;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.class_8c.api.Api;
import com.example.class_8c.data.DataPostItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimelineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimelineFragment extends Fragment {

    ArrayList<DataPostItem> arrayList;
    PostViewAdapter postViewAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TimelineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimelineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimelineFragment newInstance(String param1, String param2) {
        TimelineFragment fragment = new TimelineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Make Data
        arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataPostItem item = new DataPostItem(10,
                    true,
                    "star",
                    "https://image.ytn.co.kr/general/jpg/2019/0923/201909232130264620_t.jpg",
                    "wow!");
            arrayList.add(i, item);
        }

        // Server와 통신할 때(HTTP)
//        fetchAsyncPosts();

        // Inflate the layout for this fragment
        View baseViwe = inflater.inflate(R.layout.fragment_timeline, container, false);
        RecyclerView recyclerView = baseViwe.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        postViewAdapter = new PostViewAdapter();
        recyclerView.setAdapter(postViewAdapter);

        baseViwe.findViewById(R.id.fab_post).setOnClickListener(v -> {

            int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.READ_EXTERNAL_STORAGE);

            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                startCameraActivity();
            } else {
                Toast.makeText(getActivity(), "권한이 없습니다.", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(getActivity(),
                        new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                        2000);
            }
        });
        return baseViwe;
    }

    public void startCameraActivity() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 1000);
        }
    }

    /** Main(TimelineFrag) -> run Camera -> main -> Post **/
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == Activity.RESULT_OK) {
            Log.d("onActivityResult", "Camera SUCCESS");

            Intent startIntent = new Intent(getActivity(), PostActivity.class);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            startIntent.putExtra("photo", bitmap);
            startActivity(startIntent);
        }
    }

    private void fetchAsyncPosts() {
        arrayList = new ArrayList<>();
        FetchPostsTask fetchPostsTask = new FetchPostsTask();
        fetchPostsTask.execute(Api.GET_POST);
    }

    class FetchPostsTask extends AsyncTask<String, Void, Api.Post[]> {

        @Override
        protected Api.Post[] doInBackground(String... strings) {
            String url = strings[0];
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            try {
                Response response = client.newCall(request).execute();
                Gson gson = new Gson();
                Api.Post[] posts = gson.fromJson(response.body().charStream(), Api.Post[].class);
                return posts;
            } catch (IOException e) {
                Log.d("FetchPostsTask", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(Api.Post[] posts) {
            super.onPostExecute(posts);
            // Server에서 받은 객체를 GSON으로 변환 후 사용
//            for (Api.Post post : posts) {
//                arrayList.add(post);
//            }
            // Holder의 내용이 변경되었음을 알림
//            postViewAdapter.notifyDataSetChanged();
        }
    }

    class PostViewAdapter extends RecyclerView.Adapter<PostViewHolder> {

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View baseView = getActivity().getLayoutInflater().inflate(R.layout.item_post, parent, false);
            PostViewHolder postViewHolder = new PostViewHolder(baseView);
            return postViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TimelineFragment.PostViewHolder holder, int position) {
            DataPostItem item = arrayList.get(position);
            String url = item.getPostImgUrl();
            Glide.with(TimelineFragment.this)
//                    .load(Api.BASE_URL + url)
                    .load(url)
                    .centerCrop()
                    .into(holder.iv_post);

            holder.tv_username.setText(item.getUserName());
            holder.tv_posttext.setText(item.getPostText());
            holder.tv_postlikecount.setText(String.valueOf(item.getPostLikeCount()));
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_username, tv_postlikecount, tv_posttext;
        public ImageView iv_post;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_username = itemView.findViewById(R.id.tv_nickname);
            this.tv_postlikecount = itemView.findViewById(R.id.tv_like_count);
            this.tv_posttext = itemView.findViewById(R.id.tv_post_text);
            this.iv_post = itemView.findViewById(R.id.iv_img);
        }
    }
}