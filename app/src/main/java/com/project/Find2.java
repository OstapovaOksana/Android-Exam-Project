package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Find2 extends AppCompatActivity {
    Button back;
    TextView textView;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find2);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        back = (Button) findViewById(R.id.btnBack);
        textView = (TextView) findViewById(R.id.textView);
        String selection = "price > 100";
        Cursor c = db.query(DBHelper.TABLE_COMPANY, null, selection, null,null,null,null);
        textView.append("Кількість брендів вартістю понад $100 млрд : " );
        if(c!= null){
            if(c.moveToFirst()){
                int count = c.getCount();

                textView.append(count + "\n");
            }
            c.close();
        }else{
            textView.setText("Збігів не знайдено!");
        }
    }

    public void Back(View v){
        Intent intent = new Intent(this, Lab4.class);
        startActivity(intent);
    }
}
