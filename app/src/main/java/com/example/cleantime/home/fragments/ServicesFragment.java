package com.example.cleantime.home.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cleantime.R;
import com.example.cleantime.activities.MainActivity;


public class ServicesFragment extends Fragment implements View.OnClickListener {
    private View view;

    private LinearLayout lvSedan;
    private LinearLayout lvPremiumSedan;
    private LinearLayout lvHatchback;
    private LinearLayout lvLuxury;
    private LinearLayout lvCompactSuv;
    private LinearLayout lvSuv;

    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_services, container, false);
        initViews();
        return view;
    }

    private void initViews() {

        lvSedan = view.findViewById(R.id.lvSedan);
        lvSedan.setOnClickListener(this);

        lvPremiumSedan = view.findViewById(R.id.lvPremiumSedan);
        lvPremiumSedan.setOnClickListener(this);

        lvHatchback = view.findViewById(R.id.lvHatchback);
        lvHatchback.setOnClickListener(this);

        lvLuxury = view.findViewById(R.id.lvLuxury);
        lvLuxury.setOnClickListener(this);

        lvCompactSuv = view.findViewById(R.id.lvCompactSuv);
        lvCompactSuv.setOnClickListener(this);

        lvSuv = view.findViewById(R.id.lvSuv);
        lvSuv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == lvSedan){
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        if (view == lvPremiumSedan){
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        if (view == lvHatchback){
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        if (view == lvLuxury){
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        if (view == lvCompactSuv){
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        if (view == lvSuv){
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

    }
}