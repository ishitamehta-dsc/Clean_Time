package com.example.cleantime.activities;

import android.location.Location;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.cleantime.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE = 101;
    private static final String TAG = "MapsActivity";
    Location currentLocation;
   // FusedLocationProviderClient fusedLocationProviderClient;
    Double lat;
    Double lon;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

       // fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
//                    == PackageManager.PERMISSION_GRANTED) {
//                //get the location here
//                fusedLocationProviderClient.getLastLocation()
//                        .addOnSuccessListener(new OnSuccessListener<Location>() {
//                            @Override
//                            public void onSuccess(Location location) {
//                                if (location != null) {
//                                    lat = location.getLatitude();
//                                    lon = location.getLongitude();
//
//                                    Toast.makeText(MapsActivity.this, "" + lat + lon, Toast.LENGTH_SHORT).show();
//                                    Log.e(TAG, "onSuccess: " + lat + " " + lon);
//                                }
//                            }
//                        });
//            } else {
//                // requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, );
//            }
//        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        //  Add a marker in Sydney and move the camera
//        LatLng current = new LatLng(22.7426223, 75.8938257);
//        mMap.addMarker(new MarkerOptions().position(current));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(current));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.7426223, 75.8938257))
                .title("LinkedIn")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.7426223, 75.8938257))
                .title("Facebook")
                .snippet("Facebook HQ: Menlo Park"));

        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.7426223, 75.8938257))
                .title("Apple"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(22.7426223, 75.8938257), 10));


    }
}
