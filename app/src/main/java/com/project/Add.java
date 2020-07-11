package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add extends AppCompatActivity {
    Button add, btnBack;
    EditText etName, etPlace, etPrice, etChanges;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add = (Button) findViewById(R.id.add);
        btnBack = (Button) findViewById(R.id.btnBack);

        etName = (EditText) findViewById(R.id.etName);
        etPlace = (EditText) findViewById(R.id.etPlace);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etChanges = (EditText) findViewById(R.id.etChanges);

        dbHelper = new DBHelper(this);
    }
    public void Add(View v){
        String name = etName.getText().toString();
        String place = etPlace.getText().toString();
        String price = etPrice.getText().toString();
        String changes = etChanges.getText().toString();

        etName.setText("");
        etPlace.setText("");
        etPrice.setText("");
        etChanges.setText("");

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_NAME, name);
        contentValues.put(DBHelper.KEY_PLACE, place);
        contentValues.put(DBHelper.KEY_PRICE, price);
        contentValues.put(DBHelper.KEY_CHANGES, changes);

        database.insert(DBHelper.TABLE_COMPANY, null, contentValues);
    }

    public void Back(View v){
        Intent intent = new Intent(this, Lab4.class);
        startActivity(intent);
    }
}
