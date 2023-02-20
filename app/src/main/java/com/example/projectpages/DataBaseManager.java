package com.example.projectpages;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager extends SQLiteOpenHelper {

    private static DatabaseManager instance;
    private static final String DATABAS_NAME = "data.db";
    private static final int VERSION =2;

    public static DatabaseManager getInstance(Context context){
        if (instance == null) {
            instance = new DatabaseManager(context);
        }
        return instance;
    }

    private DatabaseManager(Context context){
        super(context, DATABAS_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + UserTable.TABLE + " (" +
                UserTable.COL_ID + " integer primary key autoincrement, " +
                UserTable.COL_USERNAME + " text, " +
                UserTable.COL_PASSWORD + " text) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean authenticate(String username, String password){
        boolean isAuthenticated = false;

        SQLiteDatabase db = getReadableDatabase();

        String sql = "select * from " + UserTable.TABLE +
                " WHERE " + UserTable.COL_USERNAME + " = ? AND " +
                UserTable.COL_PASSWORD + "= ?";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});

        if (cursor.moveToFirst()){
            isAuthenticated = true;
        }
        return isAuthenticated;
    }

    private static final class UserTable{
        private static final String TABLE = "users";
        private static final String COL_ID = "_id";
        private static final String COL_USERNAME = "usersname";
        private static final String COL_PASSWORD = "password";

    }


}
