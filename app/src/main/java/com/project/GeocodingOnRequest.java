package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeocodingOnRequest extends AppCompatActivity {

    EditText ETlat;
    EditText ETlong;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geocoding_on_request);
        ETlat = (EditText)findViewById(R.id.ETlat);
        ETlong = (EditText) findViewById(R.id.ETlong);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void GetAddress(View v){
        String lat =  ETlat.getText().toString();
        double latitude = Double.parseDouble(lat);
        String lon = ETlong.getText().toString();
        double longitude = Double.parseDouble(lon);
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try{
            List<Address> addresses = geocoder.getFromLocation(latitude,longitude,1);
            String address = addresses.get(0).getAddressLine(0);
            textView.setText(address);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void GetDistance(View v){
        GPSTracker StartP = new GPSTracker(this);
        StartP.getLocation();
        double longitudeS = StartP.getLongitude();
        double latitudeS = StartP.getLatitude();

        String lat =  ETlat.getText().toString();
        double latitudeF = Double.parseDouble(lat);
        String lon = ETlong.getText().toString();
        double longitudeF = Double.parseDouble(lon);

        CalculationDistanceByCoord(latitudeS,longitudeS,latitudeF,longitudeF);


    }

    public void CalculationDistanceByCoord(double startPointLat,double startPointLon,double endPointLat,double endPointLon){
        float[] results = new float[1];
        Location.distanceBetween(startPointLat, startPointLon, endPointLat, endPointLon, results);
        String text = Double.toString(results[0]);
        textView.setText(text + " m");
    }




    public void GoBack(View v){
        Intent intent = new Intent(this, Lab6.class);
        startActivity(intent);
    }

}
