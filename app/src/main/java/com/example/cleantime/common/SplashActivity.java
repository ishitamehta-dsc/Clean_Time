package com.example.cleantime.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleantime.R;
import com.example.cleantime.auth.LoginActivity;
import com.example.cleantime.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

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
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                if (firebaseAuth.getCurrentUser() != null) {
                    gotoHome();
                } else {
                    gotoLogin();
                }
            }
        }, 3000);
    }

    private void gotoLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void gotoHome() {
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}