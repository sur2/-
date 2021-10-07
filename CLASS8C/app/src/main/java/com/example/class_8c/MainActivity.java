package com.example.class_8c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.class_8c.data.DataPostItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    Fragment[] arrFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager
        tabLayout = findViewById(R.id.tl_tabs);
        viewPager = findViewById(R.id.vp_pager);

        arrFragments = new Fragment[2];
        arrFragments[0] = new TimelineFragment();
        arrFragments[1] = new EmptyFragment();

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    class PagerAdapter extends FragmentPagerAdapter {

        private Fragment[] arrFragments;

        public PagerAdapter(@NonNull FragmentManager fm, Fragment[] fragments) {
            super(fm);
            this.arrFragments = fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return this.arrFragments[position];
        }

        @Override
        public int getCount() {
            return this.arrFragments.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return position == 0 ? "TIMELINE" : "EMPTY";
        }
    }

}