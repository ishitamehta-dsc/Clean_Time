package com.example.cleantime.home.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cleantime.R;
import com.example.cleantime.activities.ChooseActivity;
import com.example.cleantime.activities.ChoosePaymentActivity;
import com.example.cleantime.activities.MainActivity;


public class MyPaymentFragment extends Fragment implements View.OnClickListener {

    private View view;

    private TextView tvAddPaymentMethod;


    public MyPaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_payment, container, false);
        initViews();
        return view;
    }

    private void initViews() {

        tvAddPaymentMethod = view.findViewById(R.id.tvAddPaymentMethod);
        tvAddPaymentMethod.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == tvAddPaymentMethod){
            Intent intent = new Intent(getContext(), ChooseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}