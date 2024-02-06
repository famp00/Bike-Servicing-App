package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class signup_database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SignUp.db";
    private static final String TABLE_NAME = "SignUPTable";
    private static final String Name = "Name";
    private static final String Email = "Email";
    private static final String Username = "_Username";
    private static final String Password = "Password";
    private static final String Re_Password = "RePassword";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + Name + " Varchar(255), " + Email + " Varchar(255), " + Username + " String(100) PRIMARY KEY, " + Password + " String(100), " + Re_Password + " String(100));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final int VERSION_NUMBER = 1;

    private Context context;

    public signup_database(@Nullable Context context) {
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

    /*public long insertData(String name, String username, String email, String password, String re_Password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(Username,username);
        contentValues.put(Email,email);
        contentValues.put(Password,password);
        contentValues.put(Re_Password,re_Password);
        Long rowid= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;

    }*/

    public long insertData(userdetails userdetails) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Name, userdetails.getName1());
        contentValues.put(Username, userdetails.getUsername1());
        contentValues.put(Email, userdetails.getEmail1());
        contentValues.put(Password, userdetails.getPass1());
        contentValues.put(Re_Password, userdetails.getRepass1());
        Long rowid = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return rowid;

    }

    public boolean findPassword(String username2, String password2) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
        Boolean result = false;
        if (cursor.getCount() == 0) {
            Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show();

        } else {
            while (cursor.moveToNext()) {
                String username3 = cursor.getString(3);
                String password4 = cursor.getString(4);

                if (username3.equals(username2) && password4.equals(password2)) {
                    result = true;
                    break;

                }

            }


        }
        return result;
    }
}
