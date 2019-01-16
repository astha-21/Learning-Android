package com.example.asthasharma.learningandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="simplylearningDB";
    public static final String TABLE_NAME="user_table";
    public static final String ROW_ID="id";
    public static final String ROW_NAME="name";
    public static final String ROW_EMAIL="email";
    public static final String ROW_PASSWORD="password";
    public DatabaseHandler(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE " +TABLE_NAME + " (" + ROW_ID + "INTEGER PRIMARY KEY," + ROW_NAME
                + " TEXT," + ROW_EMAIL + " TEXT" + ROW_PASSWORD + "TEXT" + " )";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }
    public int addUser(Adapter adapter){
        ContentValues cv=new ContentValues();
        cv.put(ROW_NAME,adapter.getName());
        cv.put(ROW_EMAIL,adapter.getEmail());
        cv.put(ROW_PASSWORD,adapter.getPassword());
        SQLiteDatabase db=this.getWritableDatabase();
        long res=db.insert(TABLE_NAME,null,cv);
        db.close();
        return (int) res;
    }
    public List<Adapter>getAllUser(){
        ArrayList<Adapter>data=new ArrayList<>();
        String query="SELECT * FROM " +TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=db.rawQuery(query,null);
        if(c.moveToFirst()){
            do{
                Adapter adapter=new Adapter();
                adapter.setId(Integer.parseInt(c.getString(0)));
                adapter.setName(c.getString(0));
                adapter.setEmail(c.getString(0));
                adapter.setPassword(c.getString(0));
                data.add(adapter);
            }while (c.moveToNext());
        }
        return data;
    }
    public int updateUser(Adapter adapter){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ROW_NAME,adapter.getName());
        cv.put(ROW_EMAIL,adapter.getEmail());
        cv.put(ROW_PASSWORD,adapter.getPassword());
        return db.update(TABLE_NAME,cv,ROW_ID + " = ? ",new String[]{String.valueOf(adapter.getId())});

    }
    public int deleteUser(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,ROW_ID + " = ? ",new String[]{String.valueOf(id)});
    }
}
