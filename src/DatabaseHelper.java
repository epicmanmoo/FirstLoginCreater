package com.example.nasir.logintest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;


public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String TAG= "DatabaseHelper";
    private static final String TABLE_NAME= "user";


    public DatabaseHelper(Context context) {

        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create Table user(email text, password text)");
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }

    public boolean insert(String email, String password) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        Log.d(TAG, "addData: Adding " + email + "to" + TABLE_NAME);
        long ins = db.insert("user", null, contentValues);
            if (ins == -1)
                return false;
            else
                return true;
    }

    public Boolean chkemail (String email){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0)
            return false;

        else
            return true;
    }


    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor= db.rawQuery("Select * from user where email=? and password=?", new String[]{email, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;


}



}
