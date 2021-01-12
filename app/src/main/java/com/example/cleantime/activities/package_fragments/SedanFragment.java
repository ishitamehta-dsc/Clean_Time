package com.example.cleantime.activities.package_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cleantime.R;
import com.example.cleantime.home.SchedulePickupActivity;


public class SedanFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tvAddItem;

    private static final String TAG = "SedanFragment";

    public SedanFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sedan, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        tvAddItem = view.findViewById(R.id.tvAddItem);
        tvAddItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == tvAddItem){
            gotoSchedulePickup();
        }
    }

    private void gotoSchedulePickup() {
        Intent intent = new Intent(getContext(), SchedulePickupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}