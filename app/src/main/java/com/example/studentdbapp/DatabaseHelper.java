package com.example.studentdbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String DbName="College.db";
    static String TableName="Student";
    static String co1="id";
    static String co2="Name";
    static String co3="RollNO";
    static String co4="AdminNo";
    static String co5="college";

    public DatabaseHelper( Context context ) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query="create table "+TableName+"(" +
                co1+" integer primary key autoincrement,"+
                co2+" text,"+
                co3+" text,"+
                co4+" text,"+
                co5+" text)";


        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String name,String rollno,String admission,String college)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(co2,name);
        c.put(co3,rollno);
        c.put(co4,admission);
        c.put(co5,college);

        long status=db.insert(TableName,null,c);

        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor searchData(String admissionno)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        String query="select * from "+TableName+" where "+
                co4+"='"+admissionno+"'";
       Cursor c=db.rawQuery(query,null);
        return c;
    }
}
