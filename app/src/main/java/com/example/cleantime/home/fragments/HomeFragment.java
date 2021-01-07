package com.example.cleantime.home.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.cleantime.R;
import com.example.cleantime.activities.ChoosePaymentActivity;


public class HomeFragment extends Fragment {
    private View view;
    private LinearLayout lvTypeCar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        lvTypeCar = view.findViewById(R.id.lvTypeCar);
        lvTypeCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChoosePaymentActivity.class);
                getContext().startActivity(intent);
            }
        });
        return view;
    }
}