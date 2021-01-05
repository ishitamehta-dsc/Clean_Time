package com.example.cleantime.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.cleantime.R;
import com.example.cleantime.home.fragments.MyPackageFragment;
import com.example.cleantime.home.fragments.MyProfileFragment;
import com.google.android.material.navigation.NavigationView;

import java.sql.RowId;

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

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new MyProfileFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("My Profile");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.packages:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new MyPackageFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("MyPackages");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }
                return true;
            }
        });

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