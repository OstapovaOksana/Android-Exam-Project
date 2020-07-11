package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Find1 extends AppCompatActivity {
    Button back;
    TextView textView;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find1);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        back = (Button) findViewById(R.id.btnBack);
        textView = (TextView) findViewById(R.id.textView);
        String selection = "changes >= 10";
        Cursor c = db.query(DBHelper.TABLE_COMPANY, null, selection, null,null,null,null);
        textView.append("Бренди, які у 2019р. збільшили рейтинг на 10 і більше % : \n" );
        if(c!= null){
            if(c.moveToFirst()){
                String str;
                do{
                    String cn = c.getColumnName(1);
                    str = c.getString(c.getColumnIndex(cn));

                    textView.append(str + "\n");
                }while(c.moveToNext());
            }
            c.close();
        }else{
            textView.setText("Збігів не знайдено!");
        }

        dbHelper.close();

    }

    public void Back(View v){
        Intent intent = new Intent(this, Lab4.class);
        startActivity(intent);
    }
}

