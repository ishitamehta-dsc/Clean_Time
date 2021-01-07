package com.example.cleantime.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleantime.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.tasks.OnSuccessListener;

public class ChoosePaymentActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int REQUEST_CODE = 101;
    private static final String TAG = "MapsActivity";
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    Double lat;
    Double lon;
    private GoogleMap mMap;
    private TextView tvLat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_payment);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        tvLat = findViewById(R.id.tvLat);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //get the location here
                fusedLocationProviderClient.getLastLocation()
                        .addOnSuccessListener(new OnSuccessListener<Location>() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onSuccess(Location location) {
                                if (location != null) {
                                    lat = location.getLatitude();
                                    lon = location.getLongitude();
                                    tvLat.setText(lat + " " + lon);
                                    Toast.makeText(ChoosePaymentActivity.this, "" + lat + lon, Toast.LENGTH_SHORT).show();
                                    Log.e(TAG, "onSuccess: " + lat + " " + lon);
                                }
                            }
                        });
            } else {
                // requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, );
            }
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}