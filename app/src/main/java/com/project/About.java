package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        button = (Button) findViewById(R.id.button3);
    }
    public void GoBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
