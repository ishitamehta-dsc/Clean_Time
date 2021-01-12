package com.example.cleantime.home.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.cleantime.R;
import com.example.cleantime.activities.ChoosePaymentActivity;


public class MyAddressFragment extends Fragment implements View.OnClickListener {

    private View view;

    private TextView tvAddressUpdate;


    public MyAddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_address, container, false);
        initViews();
        return view;
    }

    private void initViews() {

        tvAddressUpdate = view.findViewById(R.id.tvAddressUpdate);
        tvAddressUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == tvAddressUpdate) {
            Intent intent = new Intent(getContext(), ChoosePaymentActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            getContext().startActivity(intent);

        }
    }
}

