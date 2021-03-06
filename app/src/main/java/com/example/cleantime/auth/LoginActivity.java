package com.example.cleantime.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cleantime.R;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivGoBack;

    private EditText etPhoneNumber;

    private TextView tvGetOtp;

    private FirebaseAuth firebaseAuth;

    private final static String country = "+91";
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {

        etPhoneNumber = findViewById(R.id.etPhoneNumber);

        ivGoBack = findViewById(R.id.ivGoBack);
        ivGoBack.setOnClickListener(this);

        tvGetOtp = findViewById(R.id.tvGetOtp);
        tvGetOtp.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {

        if (view == ivGoBack){
            onBackPressed();
        }

        if (view == tvGetOtp){ 
                String phoneNumber = etPhoneNumber.getText().toString();
                validatePhoneNumber(phoneNumber);
            }

        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            finish();
        }


    private void validatePhoneNumber(String phoneNumber) {

        if (!TextUtils.isDigitsOnly(phoneNumber)){
            etPhoneNumber.setError("Enter valid phone number.");
            return;
        }

        if (TextUtils.isEmpty(phoneNumber)) {
            etPhoneNumber.setError("Phone number required.");
            return;
        }

        if (phoneNumber.length() != 10) {
            etPhoneNumber.setError("Enter a valid 10 digit phone number.");
            return;
        }
        gotoCodeScreen(phoneNumber);
    }

    private void gotoCodeScreen(String phoneNumber) {

        Intent intent = new Intent(LoginActivity.this, OTPActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("phoneNumber", phoneNumber);
        startActivity(intent);
        finish();
    }
}
