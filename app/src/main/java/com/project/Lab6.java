package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab6 extends AppCompatActivity {
    Button btnGetGPS;
    Button btnGeocoding;
    Button btnGeocodingRequest;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);
        btnGetGPS = (Button) findViewById(R.id.btnGetGPS);
        btnGeocoding = (Button) findViewById(R.id.btnGeocoding);
        btnGeocodingRequest = (Button) findViewById(R.id.btnGeocodingRequest);
        btnBack = (Button) findViewById(R.id.btnBack);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnGetGPS:
                Intent intent = new Intent(this, GetGPS.class);
                startActivity(intent);
                break;
            case R.id.btnGeocoding:
                intent = new Intent(this, Geocoding.class);
                startActivity(intent);
                break;
            case R.id.btnGeocodingRequest:
                intent = new Intent(this, GeocodingOnRequest.class);
                startActivity(intent);
                break;
            case R.id.btnBack:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHelp:
                intent = new Intent();
                intent.setAction("Lab6");
                intent.setClass(this, Help.class);
                startActivity(intent);
                break;
        }
    }
}
