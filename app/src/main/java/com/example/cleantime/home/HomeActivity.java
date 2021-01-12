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
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new HomeFragment()).commit();
                        tvToolbarTitle.setText("Home");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new MyProfileFragment()).commit();
                        tvToolbarTitle.setText("My Profile");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
//                        FragmentManager fragmentManager = getSupportFragmentManager();
//                        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//                            @Override
//                            public void onBackStackChanged() {
//                                if(getFragmentManager().getBackStackEntryCount() == 0) ;
//
//                            }
//                        });
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.packages:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new MyPackageFragment()).commit();
                        tvToolbarTitle.setText("My Packages");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.address:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new MyAddressFragment()).commit();
                        tvToolbarTitle.setText("My Address");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.vehicle:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new MyVehicleFragment()).commit();
                        tvToolbarTitle.setText("My Vehicles");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.payment:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new MyPaymentFragment()).commit();
                        tvToolbarTitle.setText("My Payments");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.notification:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new NotificationFragment()).commit();
                        tvToolbarTitle.setText("Notifications");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.requests:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new MyRequestsFragment()).commit();
                        tvToolbarTitle.setText("My Requests");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.support:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new SupportFragment()).commit();
                        tvToolbarTitle.setText("Support");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.services:
                        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.frameContent,
                                new ServicesFragment()).commit();
                        tvToolbarTitle.setText("Services");
//                        ivMenuNav.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
//                        ivMenuNav.getLayoutParams().height = 50;
//                        ivMenuNav.getLayoutParams().width = 50;
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