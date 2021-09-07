package com.example.class_5b;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment implements View.OnClickListener {

    private OnColorButtonListener onColorButtonListener;

    public LeftFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onColorButtonListener = (OnColorButtonListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("Left Fragment Debug", "onCreate: call");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        view.findViewById(R.id.v_red).setOnClickListener(this);
        view.findViewById(R.id.v_green).setOnClickListener(this);
        view.findViewById(R.id.v_blue).setOnClickListener(this);
        Log.d("Left Fragment Debug", "onCreateView: call");
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.v_red:
                onColorButtonListener.onColorClick(0);
                break;

            case R.id.v_green:
                onColorButtonListener.onColorClick(1);
                break;

            case R.id.v_blue:
                onColorButtonListener.onColorClick(2);
                break;
        }
    }
}