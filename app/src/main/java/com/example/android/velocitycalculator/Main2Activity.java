package com.example.android.velocitycalculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    float speed = 10;
    LocationManager locationManager;
    LocationListener locationListener;
    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final float maxSpeed = getIntent().getFloatExtra("maxSpeed", -1);

//        TextView textView = (TextView) findViewById(R.id.speed_meter);
//        textView.setText(Float.toString(maxSpeed));


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                //when the location changed
                Log.d("Location", "" + location);
                Log.d("Float Location", "" + location.getLongitude() + "     " + location.getLatitude());
                Log.d("Speed", "    " + location.getSpeed());

                //initializing the variable speed with the speed number given by the LocationListener
                speed = location.getSpeed();

                TextView textView = (TextView) findViewById(R.id.speed_meter);
                textView.setText(Float.toString(speed));
                if (speed >= maxSpeed) {
                    textView.setTextColor(Color.RED);
                } else {
                    textView.setTextColor(Color.GRAY);
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }


        };

        locationManager.requestLocationUpdates("gps", 1000, 0, locationListener);
    }
}
