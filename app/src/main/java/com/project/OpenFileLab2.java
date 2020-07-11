package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenFileLab2 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_file_lab2);
        textView = (TextView) findViewById(R.id.textView);
        Read();
    }

    public void Back(View v){
        Intent intent = getIntent();
        String action = intent.getAction();
        if(action.equals("Lab2")){
            intent = new Intent(this, Lab2.class);
            startActivity(intent);
        }
        else if(action.equals("Lab3")){
            intent = new Intent(this, Lab3.class);
            startActivity(intent);
        }
    }

    public void Read(){
        Intent intent = getIntent();
        String action = intent.getAction();
        if(action.equals("Lab2")){
        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput("Lab2")));
            String str = "";
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                textView.append(str+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        else if(action.equals("Lab3")){
            try {
                // открываем поток для чтения
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        openFileInput("Lab3")));
                String str = "";
                // читаем содержимое
                while ((str = br.readLine()) != null) {
//                Log.d(LOG_TAG, str);
                    textView.append(str+"\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
