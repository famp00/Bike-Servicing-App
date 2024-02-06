package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class servicing_database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Servicing.db";
    private static final String TABLE_NAME = "ClientList";
    private static final String BikeName = "BikeName";
    private static final String Registration = "Registration";
    private static final String Problem = "Problem";
    private static final String DaT = "DaT";
    private static final String PickUp = "PickUp";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + BikeName + " String(255), " + Registration + " String(255), " + Problem + " String(100), " + DaT + " String(100), " + PickUp + " String(100));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final int VERSION_NUMBER = 3;

    private Context context;

    public servicing_database (@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);

        this.context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            //Toast.makeText(context, "onCreate is Called", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

        } catch (Exception e) {

            //Toast.makeText(context, "Exeception: "+ e, Toast.LENGTH_LONG).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }






}
