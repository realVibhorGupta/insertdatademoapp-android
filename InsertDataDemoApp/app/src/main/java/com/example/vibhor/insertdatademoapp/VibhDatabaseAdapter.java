package com.example.vibhor.insertdatademoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vibhor on 01-May-16.
 */
public class VibhDatabaseAdapter {
y
    vibhOpenHelper vibhOpenHelper;

    VibhDatabaseAdapter(Context context) {

        vibhOpenHelper = new vibhOpenHelper(context);
    }


    public long insertData(String username, String password) {


        SQLiteDatabase sqLiteDatabase = vibhOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(vibhOpenHelper.USERNAME, username);
        contentValues.put(vibhOpenHelper.PASSWORD, password);
        long id = sqLiteDatabase.insert(vibhOpenHelper.DATABASE_NAME, null, contentValues);


        return id;


    }


   static class vibhOpenHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "login_account_database";
        public static final String TABLE_NAME = "login_table";
        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String UID = "_id";
        public static final int DATABASE_VERSION = 1;
        public static final String CREATE_TABLE = "CREATE TABLE  " + TABLE_NAME + "( " + UID + "INTEGER PRIMARY KEY AUTO_INCREMENT" +
                " , " + USERNAME + " VARCHAR(255)" + PASSWORD + "PASSWORD VARCHAR(255))";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        Context context;


        public vibhOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        /**
         * Called when the database is created for the first time. This is where the
         * creation of tables and the initial population of the tables should happen.
         *
         * @param db The database.
         */
        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                Message.message(context, "onCreate MEthod Called");
            }

        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                Message.message(context, "onUpgrade method called");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Message.message(context, "onUpgrade something went wrong");
            }


        }
    }


}
