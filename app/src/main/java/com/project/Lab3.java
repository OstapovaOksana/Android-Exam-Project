package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Lab3 extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    public double a = 12;
    public double b = 22;
    public double y = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
    }

    public void writeFile(String fileName, String res){

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, MODE_APPEND)));

            writer.write(res);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput("Lab3", MODE_PRIVATE)));
            bw.write("");
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFile(View v){

        double x1, x2, h, res;
        if(editText1.length() == 0 || editText2.length() == 0 || editText3.length() == 0 ){
            Toast toast = Toast.makeText(Lab3.this, "Заповніть усі поля!", Toast.LENGTH_SHORT);
            toast.getView().setVisibility(View.INVISIBLE);

        }
        else{
            String A = editText1.getText().toString();
            x1 = Double.parseDouble(A);
            String B = editText2.getText().toString();
            x2 = Double.parseDouble(B);
            String H = editText3.getText().toString();
            h = Double.parseDouble(H);
            createFile();


            for(double i = x1; i<=x2; i+=h){
                res = (Math.sqrt(i + b - a) + Math.log(y))/(Math.atan(b + a));
                String Res = Double.toString(res);
                String text = i + "," + Res;
                writeFile("Lab3", text+"\n");
            }}

        Intent intent = new Intent();
        intent.setAction("Lab3");
        intent.setClass(this, OpenFileLab2.class);
        startActivity(intent);

    }

    public void Back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void OpenGraphic(View v){
        Intent intent = new Intent(this, OpenGraphLab3.class);
        startActivity(intent);
    }
    public void Help(View v){
        Intent intent = new Intent();
        intent.setAction("Lab3");
        intent.setClass(this, Help.class);
        startActivity(intent);
    }
}
