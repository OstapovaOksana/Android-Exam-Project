package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab4 extends AppCompatActivity {
    String name[] = {"Apple", "Google", "Amazon", "Microsoft", "Coca-Cola", "Samsung", "Toyota", "Mercedes-Benz",
            "McDonald's", "Disney", "BMW"};
    int place[] = {1,2,3,4,5,6,7,8,9,10,11};
    double price[] = {234.241,167.713,125.263,108.847,63.365,61.098,56.246,50.832,45.362,44.352,41.440};
    int changes[] = {9,8,24,17,-4,2,5,5,4,11,1};
    Button btnAdd, btnRead, btnUpdate, btnDelete, btnFind1, btnFind2, btnBack;
    DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnFind1 = (Button) findViewById(R.id.btnFind1);
        btnFind2 = (Button) findViewById(R.id.btnFind2);
        btnBack = (Button) findViewById(R.id.btnBack);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        Cursor c = db.query(DBHelper.TABLE_COMPANY, null,null,null,null,null, null);
        if(c.getCount() == 0){
            ContentValues cv = new ContentValues();
            for(int i = 0; i < 11; i++){
                cv.put(DBHelper.KEY_NAME, name[i]);
                cv.put(DBHelper.KEY_PLACE, place[i]);
                cv.put(DBHelper.KEY_PRICE, price[i]);
                cv.put(DBHelper.KEY_CHANGES, changes[i]);
                db.insert(DBHelper.TABLE_COMPANY, null, cv);
            }
        }
        c.close();
        dbHelper.close();
    }

    public void onClick(View v){

        switch(v.getId()){

            case R.id.btnAdd:
                Intent intent = new Intent(this, Add.class);
                startActivity(intent);
                break;
            case R.id.btnRead:
                intent = new Intent(this, Load.class);
                startActivity(intent);
                break;
            case R.id.btnUpdate:
                intent = new Intent(this, Update.class);
                startActivity(intent);
                break;
            case R.id.btnDelete:
                intent = new Intent(this, Delete.class);
                startActivity(intent);
                break;
            case R.id.btnFind1:
                intent = new Intent(this, Find1.class);
                startActivity(intent);
                break;
            case R.id.btnFind2:
                intent = new Intent(this, Find2.class);
                startActivity(intent);
                break;
            case R.id.btnBack:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHelp:
                intent = new Intent();
                intent.setAction("Lab4");
                intent.setClass(this, Help.class);
                startActivity(intent);
                break;
            }
        }
    }
