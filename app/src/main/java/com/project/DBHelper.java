package com.project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "companyDb";
    public static final String TABLE_COMPANY = "company";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PLACE = "place";
    public static final String KEY_PRICE = "price";
    public static final String KEY_CHANGES = "changes";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_COMPANY + "(" + KEY_ID
                + " integer primary key," + KEY_NAME + " text," + KEY_PLACE + " integer,"
                + KEY_PRICE + " real," + KEY_CHANGES + " integer" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_COMPANY);

        onCreate(db);

    }
}
