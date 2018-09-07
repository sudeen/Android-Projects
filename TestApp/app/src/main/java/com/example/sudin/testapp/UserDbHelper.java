package com.example.sudin.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by SUNITA on 11/23/2016.
 */

public class UserDbHelper extends SQLiteOpenHelper {
    private static UserDbHelper databaseHelper;
    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+ UserContract.NewUserInfo.TABLE_NAME+"("+ UserContract.NewUserInfo.USER_NAME+" TEXT,"
            +UserContract.NewUserInfo.USER_SECURITY+" TEXT,"+ UserContract.NewUserInfo.USER_EMAIL+" TEXT);";
    public UserDbHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);

    }

    public static UserDbHelper getInstance(Context context){
        if(UserDbHelper.databaseHelper == null){
            databaseHelper = new UserDbHelper(context);
            Log.d("databse creation", "successfull");
            return databaseHelper;
        }else{
            Log.d("database creation", "old Database");
            return databaseHelper;
        }
    }

    public void addInformations(String  name, String security, String email, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();

        //String query= "select * from USERINFO";
        //Cursor cursor=db.rawQuery(query,null);

        contentValues.put(UserContract.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContract.NewUserInfo.USER_SECURITY,security);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL,email);
        db.insert(UserContract.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS","One row inserted...");

    }

    /*public String searchPass(SQLiteDatabase db, String name){
        db=this.getReadableDatabase();
        String query= "select name, security from "+ UserContract.NewUserInfo.TABLE_NAME;
        Cursor cursor= db.rawQuery(query, null);
        String a, b;
        b="Not Found";
        if(cursor.moveToFirst()){
            do{
                a= cursor.getString(0);
                if(a.equals(name)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }
*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL("DROP TABLE IF EXISTS "+ UserContract.NewUserInfo.TABLE_NAME);
            Log.d("onUpgrade", " version changed");
            onCreate(db);
        }catch(SQLiteException sq){
            sq.printStackTrace();
        }


    }



}
