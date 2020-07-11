package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Load extends AppCompatActivity {
    Button btnBack;
    TextView textView;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        btnBack = (Button) findViewById(R.id.btnBack);

        textView = (TextView) findViewById(R.id.textView);

        dbHelper = new DBHelper(this);

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_COMPANY,null,null,null,null,null,null);

        if(cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int placeIndex = cursor.getColumnIndex(DBHelper.KEY_PLACE);
            int priceIndex = cursor.getColumnIndex(DBHelper.KEY_PRICE);
            int changesIndex = cursor.getColumnIndex(DBHelper.KEY_CHANGES);

            do{
                textView.append(" ID = " + cursor.getInt(idIndex) +
                        ", Name = " + cursor.getString(nameIndex) +
                        ", Place = " + cursor.getInt(placeIndex) +
                        ", Price = " + cursor.getDouble(priceIndex) + " $m" +
                        ", Changes = " + cursor.getInt(changesIndex) + "%" + "\n");
            }while(cursor.moveToNext());
        }else{
            textView.setText("Database is empty");
        }
        cursor.close();
    }

    public void Back(View v){
        Intent intent = new Intent(this, Lab4.class);
        startActivity(intent);
    }
}
