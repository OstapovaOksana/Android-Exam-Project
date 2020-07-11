package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab1 extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    Button button2;
    public double a = 12;
    public double b = 22;
    public double y = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button2 = (Button) findViewById(R.id.button2);
    }

    public void ClickButton(View v){
        double x, res;
        String X = editText.getText().toString();
        x = Double.parseDouble(X);
        res = (Math.sqrt(x + b - a) + Math.log(y))/(Math.atan(b + a));
        String Res = Double.toString(res);
        textView.setText(Res);
    }
    public void Back(View v ){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Help(View v){
        Intent intent = new Intent();
        intent.setAction("Lab1");
        intent.setClass(this, Help.class);
        startActivity(intent);
    }
}
