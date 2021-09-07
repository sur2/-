package com.example.class_5b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnColorButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GreenFragment GreenFragment = new GreenFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_right, GreenFragment).commit();
    }

    // Color
    // 0 : red
    // 1 : green
    // 2 : blue
    @Override
    public void onColorClick(int color) {
        Fragment fragment = null;
        switch (color) {
            case 0:
                fragment = new RedFragment();
                break;
            case 1:
                fragment = new GreenFragment();
                break;
            case 2:
                fragment = new BlueFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.fl_right, fragment).commit();
    }
}