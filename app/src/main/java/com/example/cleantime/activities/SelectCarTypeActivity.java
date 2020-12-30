package com.example.cleantime.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.cleantime.R;

public class SelectCarTypeActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cvAcw;
    private ImageView ivAcw;
    private TextView tvAcw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car_type);

        initViews();
    }

    private void initViews() {
        cvAcw = findViewById(R.id.cvAcw);
        ivAcw = findViewById(R.id.ivAcw);
        tvAcw = findViewById(R.id.tvAcw);

        cvAcw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == cvAcw) {
            changeUI();
        }
    }

    private void changeUI() {
        cvAcw.setBackgroundColor(getResources().getColor(R.color.blue));
        ivAcw.setImageDrawable(getResources().getDrawable(R.drawable.acw_selected));
        tvAcw.setTextColor(getResources().getColor(R.color.white));
    }
}