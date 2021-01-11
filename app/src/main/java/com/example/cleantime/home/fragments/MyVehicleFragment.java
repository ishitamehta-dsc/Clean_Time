package com.example.cleantime.home.fragments;

import android.media.Image;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cleantime.R;


public class MyVehicleFragment extends Fragment implements View.OnClickListener {
    
    private View view;
    private ImageView ivAddVehicle;
    private RecyclerView rvMyVehicles;

    private ImageView ivGoBack;


    public MyVehicleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_vehicle, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        ivAddVehicle = view.findViewById(R.id.ivAddVehicle);
        ivAddVehicle.setOnClickListener(this);

        rvMyVehicles = view.findViewById(R.id.rvMyVehicles);
        ivGoBack = view.findViewById(R.id.ivGoBack);

    }

    @Override
    public void onClick(View view) {

        if (view == ivGoBack){
            OnBackPressed();

        }

        if (view == ivAddVehicle){
            gotoAddVehicles();
        }

    }

    private void OnBackPressed() {


    }

    private void gotoAddVehicles() {

        Fragment fragment = new ServicesFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContent, fragment);
        fragmentTransaction.commit();

    }
}