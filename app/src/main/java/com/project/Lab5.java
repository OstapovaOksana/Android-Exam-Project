package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab5 extends AppCompatActivity {
    Button btnLoadAll;
    Button btnLoadChunk;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
        btnLoadAll = (Button) findViewById(R.id.btnLoadAll);
        btnLoadChunk = (Button) findViewById(R.id.btnLoadChunk);
        btnBack = (Button) findViewById(R.id.btnBack);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnLoadAll:
                Intent intent = new Intent(this, LoadAll.class);
                startActivity(intent);
                break;
            case R.id.btnLoadChunk:
                intent = new Intent(this, LoadChunk.class);
                startActivity(intent);
                break;
            case R.id.btnBack:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHelp:
                intent = new Intent();
                intent.setAction("Lab5");
                intent.setClass(this, Help.class);
                startActivity(intent);
                break;
        }
    }
}
