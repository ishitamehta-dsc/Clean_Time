package com.example.cleantime.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cleantime.R;
import com.example.cleantime.home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTPActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout lvCodeScreen;

    private TextView tvVerify;
    private TextView tvResendCode;
    private TextView tvCodeNotice;

    private EditText etOTP1;
    private EditText etOTP2;
    private EditText etOTP3;
    private EditText etOTP4;
    private EditText etOTP5;
    private EditText etOTP6;

    private String phoneNumber;

    private FirebaseAuth firebaseAuth;

    private String phoneVerificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            verificationCallbacks;
    private PhoneAuthProvider.ForceResendingToken resendToken;

    private final static String country = "+91";
    private static final String TAG = "OtpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        initViews();
    }

    private void initViews() {
        tvVerify = findViewById(R.id.tvVerify);
        tvVerify.setOnClickListener(this);

        tvResendCode = findViewById(R.id.tvResendCode);
        tvResendCode.setOnClickListener(this);

        etOTP1 = findViewById(R.id.etOTP1);
        etOTP2 = findViewById(R.id.etOTP2);
        etOTP3 = findViewById(R.id.etOTP3);
        etOTP4 = findViewById(R.id.etOTP4);
        etOTP5 = findViewById(R.id.etOTP5);
        etOTP6 = findViewById(R.id.etOTP6);
        setUpOTPInputs();


        lvCodeScreen = findViewById(R.id.lvCodeScreen);
        tvCodeNotice = findViewById(R.id.tvCodeNotice);
//        tvCodeNotice.setText(String.format("Enter the code you have received via sms on %s",
//                        getIntent().getStringExtra("phoneNumber")));
        phoneNumber = getIntent().getStringExtra("phoneNumber");

        firebaseAuth = FirebaseAuth.getInstance();
        
        setNotice();
        sendCode();
    }

    private void setUpOTPInputs() {

        etOTP1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    etOTP2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    etOTP3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    etOTP4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    etOTP5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etOTP5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().trim().isEmpty()){
                    etOTP6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void sendCode() {

        setUpVerificationCallbacks();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(country + phoneNumber, 60, TimeUnit.SECONDS, this, verificationCallbacks );
    }

    private void setUpVerificationCallbacks() {
        Log.e(TAG, "setUpVerificationCallbacks: ");
        verificationCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
                Log.e(TAG, "onVerificationCompleted: ");
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Log.e(TAG, "onVerificationFailed: " + e);
                if (e instanceof FirebaseAuthInvalidCredentialsException){
                    Log.e(TAG, "onVerificationFailed: ");
                    Snackbar.make(lvCodeScreen, "Invalid Credentials", Snackbar.LENGTH_SHORT).show();
                }else if (e instanceof FirebaseTooManyRequestsException){
                    Log.e(TAG, "onVerificationFailed: ");
                    Snackbar.make(lvCodeScreen, "Limit has been reached, try again in few hours", Snackbar.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                tvResendCode.setVisibility(View.VISIBLE);
                phoneVerificationId = s;
                resendToken = forceResendingToken;
                Log.e(TAG, "onCodeSent: ");
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
                Log.e(TAG, "onCodeAutoRetrievalTimeOut: ");
            }
        };

    }

    private void resendCode() {
        setUpVerificationCallbacks();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(country + phoneNumber, 60, TimeUnit.SECONDS, this, verificationCallbacks, resendToken);

    }

    private void doVerifyCode() {

        if (etOTP1.getText().toString().trim().isEmpty()
                || etOTP2.getText().toString().trim().isEmpty()
                || etOTP3.getText().toString().trim().isEmpty()
                || etOTP4.getText().toString().trim().isEmpty()
                || etOTP5.getText().toString().trim().isEmpty()
                || etOTP6.getText().toString().trim().isEmpty()) {
            Toast.makeText(OTPActivity.this, "Please enter valid OTP", Toast.LENGTH_SHORT).show();
            return;
        }

        String otp = etOTP1.getText().toString()+
                etOTP2.getText().toString()+
                etOTP3.getText().toString()+
                etOTP4.getText().toString()+
                etOTP5.getText().toString()+
                etOTP6.getText().toString();

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(phoneVerificationId, otp);
        signInWithPhoneAuthCredential(credential);

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.e(TAG, "onComplete: ");
                            Snackbar.make(lvCodeScreen, "Successful", Snackbar.LENGTH_LONG).show();
                            String cred = task.getResult().getUser().getPhoneNumber();
                            cred.replace("+91", "");
                            goToHome();
                           // checkUser(firebaseAuth.getCurrentUser().getUid());
                        } else {
                            if (task.getException() instanceof
                                FirebaseAuthInvalidCredentialsException ){
                                Log.e(TAG, "onComplete: ");
                                Snackbar.make(lvCodeScreen, "Invalid Credentials", Snackbar.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }

    private void setNotice() {
        String codeNotice = getResources().getString(R.string.code_notice) + " " + phoneNumber + ".";
        tvCodeNotice.setText(codeNotice);
        Log.e(TAG, "setNotice: ");
    }

    @Override
    public void onClick(View v) {
        if (v == tvVerify) {
            doVerifyCode();
        }
        
        if (v == tvResendCode){
            resendCode();
        }
    }

    private void goToHome() {
        Intent intent = new Intent(OTPActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}