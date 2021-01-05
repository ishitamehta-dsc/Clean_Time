package com.example.cleantime.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.cleantime.R;
import com.example.cleantime.auth.LoginActivity;
import com.example.cleantime.home.fragments.AboutFragment;
import com.example.cleantime.home.fragments.MyAddressFragment;
import com.example.cleantime.home.fragments.MyPackageFragment;
import com.example.cleantime.home.fragments.MyPaymentFragment;
import com.example.cleantime.home.fragments.MyProfileFragment;
import com.example.cleantime.home.fragments.MyRequestsFragment;
import com.example.cleantime.home.fragments.MyVehicleFragment;
import com.example.cleantime.home.fragments.NotificationFragment;
import com.example.cleantime.home.fragments.SupportFragment;
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
                        tvToolbarTitle.setText("My Packages");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.address:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new MyAddressFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("My Address");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.vehicle:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new MyVehicleFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("My Vehicles");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.payment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new MyPaymentFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("My Payments");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new NotificationFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("Notifications");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.requests:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new MyRequestsFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("My Requests");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.support:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new SupportFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("Support");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.about:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent,
                                new AboutFragment()).addToBackStack(null).commit();
                        tvToolbarTitle.setText("About");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logout:
                        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                        builder.setTitle("LOGOUT");
                        builder.setMessage("Are you sure you want to Logout ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();

                            }
                        });
                       builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.cancel();
                           }
                       });
                       AlertDialog alert1 = builder.create();
                       alert1.show();
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