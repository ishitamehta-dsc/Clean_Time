package com.example.cleantime.home;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.cleantime.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;

    private ImageView ivMenuNav;
    private ImageView ivNotification;

    private TextView tvToolbarTitle;
    private FrameLayout frameContent;
    private NavigationView nav_view;

    private LinearLayout lhActionBarContent;

    private static final String TAG = "HomeActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
    }

    private void initViews() {
        drawerLayout = findViewById(R.id.drawerLayout);

        ivMenuNav = findViewById(R.id.ivMenuNav);
        ivNotification = findViewById(R.id.ivNotification);

        tvToolbarTitle = findViewById(R.id.tvToolbarTitle);
        frameContent = findViewById(R.id.frameContent);

        nav_view = findViewById(R.id.nav_view);


        ivMenuNav.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == ivMenuNav) {
            openMenu();
        }

    }

    private void openMenu() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}