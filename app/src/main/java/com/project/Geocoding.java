package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Geocoding extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geocoding);
        textView = (TextView) findViewById(R.id.textView);
        GPSTracker gps = new GPSTracker(Geocoding.this);
        gps.getLocation();
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        if(gps.canGetLocation()){
            double longitude = gps.getLongitude();
            double latitude = gps.getLatitude();
            try{
                List<Address> addresses = geocoder.getFromLocation(latitude,longitude,1);
                String address = addresses.get(0).getAddressLine(0);
                textView.append(address);

            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void GoBack(View v){
        Intent intent = new Intent(this, Lab6.class);
        startActivity(intent);
    }
}
