package com.example.cleantime.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleantime.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivGoBack;

    private TextView tvSedan;
    private TextView tvHatchback;
    private TextView tvSUV;
    private TextView tvLuxury;
    private TextView tvTabSelected;

    private LinearLayout lvSedan;
    private LinearLayout lvHatchback;
    private LinearLayout lvSUV;
    private LinearLayout lvLuxury;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        ivGoBack =findViewById(R.id.ivGoBack);

        tvSedan = findViewById(R.id.tvSedan);
        tvHatchback = findViewById(R.id.tvHatchback);
        tvSUV = findViewById(R.id.tvSUV);
        tvLuxury = findViewById(R.id.tvLuxury);
        tvTabSelected = findViewById(R.id.tvTabSelected);

        lvSedan = findViewById(R.id.lvSedan);
        lvHatchback = findViewById(R.id.lvHatchback);
        lvSUV = findViewById(R.id.lvSUV);
        lvLuxury = findViewById(R.id.lvLuxury);

        tvSedan.setOnClickListener(this);
        tvHatchback.setOnClickListener(this);
        tvSUV.setOnClickListener(this);
        tvLuxury.setOnClickListener(this);

        switchSedan();

    }

    @Override
    public void onClick(View v) {
        if (v == ivGoBack){
            onBackPressed();
        }

        if (v == tvSedan) {
            switchSedan();
        }
        if (v == tvHatchback) {
            switchHatchback();
        }
        if (v == tvSUV) {
            switchSUV();
        }
        if (v == tvLuxury) {
            switchLuxury();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @SuppressLint("SetTextI18n")
    private void switchLuxury() {
        tvTabSelected.setText("Luxury");
        tvLuxury.setBackground(getResources().getDrawable(R.drawable.btn_bg));
        tvLuxury.setTextColor(getResources().getColor(R.color.white));

        tvSUV.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvSUV.setTextColor(getResources().getColor(R.color.black));

        tvHatchback.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvHatchback.setTextColor(getResources().getColor(R.color.black));

        tvSedan.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvSedan.setTextColor(getResources().getColor(R.color.black));

        lvLuxury.setVisibility(View.VISIBLE);
        lvSUV.setVisibility(View.GONE);
        lvHatchback.setVisibility(View.GONE);
        lvSedan.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    private void switchSUV() {

        tvTabSelected.setText("SUV");
        tvLuxury.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvLuxury.setTextColor(getResources().getColor(R.color.black));

        tvSUV.setBackground(getResources().getDrawable(R.drawable.btn_bg));
        tvSUV.setTextColor(getResources().getColor(R.color.white));

        tvHatchback.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvHatchback.setTextColor(getResources().getColor(R.color.black));

        tvSedan.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvSedan.setTextColor(getResources().getColor(R.color.black));

        lvLuxury.setVisibility(View.GONE);
        lvSUV.setVisibility(View.VISIBLE);
        lvHatchback.setVisibility(View.GONE);
        lvSedan.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    private void switchHatchback() {
        tvTabSelected.setText("Hatchback");
        tvLuxury.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvLuxury.setTextColor(getResources().getColor(R.color.black));

        tvSUV.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvSUV.setTextColor(getResources().getColor(R.color.black));

        tvHatchback.setBackground(getResources().getDrawable(R.drawable.btn_bg));
        tvHatchback.setTextColor(getResources().getColor(R.color.white));

        tvSedan.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvSedan.setTextColor(getResources().getColor(R.color.black));

        lvLuxury.setVisibility(View.GONE);
        lvSUV.setVisibility(View.GONE);
        lvHatchback.setVisibility(View.VISIBLE);
        lvSedan.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    private void switchSedan() {
        tvTabSelected.setText("Sedan");
        tvLuxury.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvLuxury.setTextColor(getResources().getColor(R.color.black));

        tvSUV.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvSUV.setTextColor(getResources().getColor(R.color.black));

        tvHatchback.setBackground(getResources().getDrawable(R.drawable.unselected_bg));
        tvHatchback.setTextColor(getResources().getColor(R.color.black));

        tvSedan.setBackground(getResources().getDrawable(R.drawable.btn_bg));
        tvSedan.setTextColor(getResources().getColor(R.color.white));

        lvLuxury.setVisibility(View.GONE);
        lvSUV.setVisibility(View.GONE);
        lvHatchback.setVisibility(View.GONE);
        lvSedan.setVisibility(View.VISIBLE);
    }
}