package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    Button btnDelete, btnBack;
    EditText etId;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnBack = (Button) findViewById(R.id.btnBack);

        etId = (EditText) findViewById(R.id.etId);

        dbHelper = new DBHelper(this);
    }

    public void Delete(View v){
        String id = etId.getText().toString();
        etId.setText("");
        if(id.equalsIgnoreCase("")){
            Toast toast = Toast.makeText(Delete.this, "Enter ID", Toast.LENGTH_SHORT);
            toast.show();
        }
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        int delCount = database.delete(DBHelper.TABLE_COMPANY, DBHelper.KEY_ID + "= " + id, null);
        Toast toast = Toast.makeText(Delete.this, "Deleted rows count = " + delCount, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Back(View v){
        Intent intent = new Intent(this, Lab4.class);
        startActivity(intent);
    }
}
