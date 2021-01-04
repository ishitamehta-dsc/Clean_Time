package com.example.cleantime.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleantime.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initViews();
    }

    private void initViews() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToOnBoard();
            }
        }, 3000);
    }

    private void goToOnBoard() {
        Intent intent = new Intent(SplashActivity.this, OnBoardingActivity.class);
        startActivity(intent);
        finish();
    }
}