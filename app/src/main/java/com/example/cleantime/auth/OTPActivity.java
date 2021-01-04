package com.example.cleantime.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleantime.R;
import com.example.cleantime.home.HomeActivity;

public class OTPActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        initViews();
    }

    private void initViews() {
        tvVerify = findViewById(R.id.tvVerify);


        tvVerify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvVerify) {
            goToHome();
        }
    }

    private void goToHome() {
        Intent intent = new Intent(OTPActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}