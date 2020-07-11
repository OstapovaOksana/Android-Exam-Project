package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    Button btnUpdate, btnBack;
    EditText etId, etName, etPlace, etPrice, etChanges;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        btnUpdate = (Button) findViewById(R.id.add);
        btnBack = (Button) findViewById(R.id.btnBack);

        etId = (EditText) findViewById(R.id.etId);
        etName = (EditText) findViewById(R.id.etName);
        etPlace = (EditText) findViewById(R.id.etPlace);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etChanges = (EditText) findViewById(R.id.etChanges);

        dbHelper = new DBHelper(this);
    }

    public void Update(View v){
        String id = etId.getText().toString();
        String name = etName.getText().toString();
        String place = etPlace.getText().toString();
        String price = etPrice.getText().toString();
        String changes = etChanges.getText().toString();

        etId.setText("");
        etName.setText("");
        etPlace.setText("");
        etPrice.setText("");
        etChanges.setText("");

        if(id.equalsIgnoreCase("")){
            Toast toast = Toast.makeText(Update.this, "Enter ID", Toast.LENGTH_SHORT);
            toast.show();
        }

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_NAME, name);
        contentValues.put(DBHelper.KEY_PLACE, place);
        contentValues.put(DBHelper.KEY_PRICE, price);
        contentValues.put(DBHelper.KEY_CHANGES, changes);

        int updCount = database.update(DBHelper.TABLE_COMPANY, contentValues, DBHelper.KEY_ID + "= ?", new String[] {id});
        Toast toast = Toast.makeText(Update.this, "Updates rows count = " + updCount, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Back(View v){
        Intent intent = new Intent(this, Lab4.class);
        startActivity(intent);
    }
}
