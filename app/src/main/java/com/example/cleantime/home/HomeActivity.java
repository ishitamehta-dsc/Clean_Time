package com.example.cleantime.home;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.cleantime.R;
import com.example.cleantime.auth.LoginActivity;
import com.example.cleantime.home.fragments.HomeFragment;
import com.example.cleantime.home.fragments.MyAddressFragment;
import com.example.cleantime.home.fragments.MyPackageFragment;
import com.example.cleantime.home.fragments.MyPaymentFragment;
import com.example.cleantime.home.fragments.MyProfileFragment;
import com.example.cleantime.home.fragments.MyRequestsFragment;
import com.example.cleantime.home.fragments.MyVehicleFragment;
import com.example.cleantime.home.fragments.NotificationFragment;
import com.example.cleantime.home.fragments.ServicesFragment;
import com.example.cleantime.home.fragments.SupportFragment;
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
        getSupportFragmentManager().beginTransaction().replace(R.id.frameContent, new
                HomeFragment()).commit();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {


                    case R.id.home:
                        fragmentReplace(new HomeFragment(), "home");
                        tvToolbarTitle.setText("Home");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.profile:
                        fragmentReplace(new MyProfileFragment(), "myProfile");
                        tvToolbarTitle.setText("My Profile");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.packages:
                        fragmentReplace(new MyPackageFragment(), "myPackage");
                        tvToolbarTitle.setText("My Packages");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.address:
                        fragmentReplace(new MyAddressFragment(), "myAddress");
                        tvToolbarTitle.setText("My Address");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.vehicle:
                        fragmentReplace(new MyVehicleFragment(), "myVehicle");
                        tvToolbarTitle.setText("My Vehicles");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.payment:
                        fragmentReplace(new MyPaymentFragment(), "myPayment");
                        tvToolbarTitle.setText("My Payments");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.notification:
                        fragmentReplace(new NotificationFragment(), "notification");
                        tvToolbarTitle.setText("Notifications");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.requests:
                        fragmentReplace(new MyRequestsFragment(), "myRequest");
                        tvToolbarTitle.setText("My Requests");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.support:
                        fragmentReplace(new SupportFragment(), "support");
                        tvToolbarTitle.setText("Support");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.services:
                        fragmentReplace(new ServicesFragment(), "service");
                        tvToolbarTitle.setText("Services");
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

    public void fragmentReplace(Fragment fragment, String tag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContent,fragment , tag);
        fragmentTransaction.addToBackStack(null); //this will add it to back stack
        fragmentTransaction.commit();
    }

    private void openMenu() {
        drawerLayout.openDrawer(GravityCompat.START);
    }


}