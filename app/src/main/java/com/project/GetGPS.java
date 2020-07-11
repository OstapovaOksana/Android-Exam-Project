package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetGPS extends AppCompatActivity {
    Button btnBack;
    Button btnGet;
    static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_gps);
        btnBack = (Button) findViewById(R.id.btnAbout);
        btnGet = (Button) findViewById(R.id.btnGet);
        textView = (TextView) findViewById(R.id.textView);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker gps = new GPSTracker(GetGPS.this);
                gps.getLocation();
                if(gps.canGetLocation()){
                    double longitude = gps.getLongitude();
                    double latitude = gps.getLatitude();

                    textView.append("\nLat:" + latitude + "  Long:" + longitude);


                }else {
                    gps.showSettingsAlert();
                }
            }
        });
    }
    public void GoBack(View v){
        Intent intent = new Intent(this, Lab6.class);
        startActivity(intent);
    }

    public  void OnMap(View v){
        Intent intent = new Intent(this, OnMap.class);
        startActivity(intent);
    }
}
