package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Lab1;
    Button Lab2;
    Button Lab3;
    Button Lab4;
    Button Lab5;
    Button Lab6;
    Button About;
    Button Help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lab1 = (Button) findViewById(R.id.btnLab1);
        Lab2 = (Button) findViewById(R.id.btnLab2);
        Lab3 = (Button) findViewById(R.id.btnLab3);
        Lab4 = (Button) findViewById(R.id.btnLab4);
        Lab5 = (Button) findViewById(R.id.btnLab5);
        Lab6 = (Button) findViewById(R.id.btnLab6);
        About = (Button) findViewById(R.id.btnAbout);
        Help = (Button) findViewById(R.id.btnHelp);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnLab1:
                Intent intent = new Intent(this, Lab1.class);
                startActivity(intent);
                break;
            case R.id.btnLab2:
                intent = new Intent(this, Lab2.class);
                startActivity(intent);
                break;
            case R.id.btnLab3:
                intent = new Intent(this, Lab3.class);
                startActivity(intent);
                break;
            case R.id.btnLab4:
                intent = new Intent(this, Lab4.class);
                startActivity(intent);
                break;
            case R.id.btnLab5:
                intent = new Intent(this, Lab5.class);
                startActivity(intent);
                break;
            case R.id.btnLab6:
                intent = new Intent(this, Lab6.class);
                startActivity(intent);
                break;
            case R.id.btnAbout:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;
            case R.id.btnHelp:
                intent = new Intent();
                intent.setAction("Main");
                intent.setClass(this, Help.class);
                startActivity(intent);
                break;
        }
    }
}
