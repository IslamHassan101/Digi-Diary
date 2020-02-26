package com.example.digi_diary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

public class  SqlLiteHelper extends SQLiteOpenHelper {


    public SqlLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void createTable(){
        SQLiteDatabase database= getWritableDatabase();
        String sql ="CREATE TABLE IF NOT EXISTS DIARIES(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " text VARCHAR, text2 VARCHAR, diarydate VARCHAR, " +
                "lastupdated VARCHAR, image BLOB, deleted INTEGER, favourite INTEGER)";
        database.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public void insertData(String text1v, String text2v, String diarydate, String lastupdated, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO DIARIES(text, text2, diarydate, lastupdated, image, deleted, favourite) VALUES (?,?,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, text1v);
        statement.bindString(2, text2v);
        statement.bindString(3, diarydate);
        statement.bindString(4, lastupdated);
        statement.bindBlob(5, image);
        statement.bindDouble(6,0);
        statement.bindDouble(7,0);
        statement.executeInsert();
        Log.d("checkDx",statement.toString());
    }

    public void  updateData(String text1, String text2, String diarydate, String lastupdated, byte[] image, int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE DIARIES SET text = ?, text2 = ?, diarydate = ?, lastupdated = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindString(1,text1);
        statement.bindString(2,text2);
        statement.bindString(3,diarydate);
        statement.bindString(4,lastupdated);
        statement.bindBlob(5,image);
        statement.bindDouble(6,(double)id);
        statement.execute();
        database.close();
    }


    public void  softDeleteDiary(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE DIARIES SET deleted = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindDouble(1,1);
        statement.bindDouble(2,(double)id);
        statement.execute();
        database.close();
    }

    public void addDiaryToFavourites(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE DIARIES SET favourite = 1 WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindDouble(1,(double)id);
        statement.execute();
        database.close();
    }
    public void removeDiaryFromFavourites(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE DIARIES SET favourite = 0 WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindDouble(1,(double)id);
        statement.execute();
        database.close();
    }
    public void deleteDiary(int id){
        SQLiteDatabase database = getWritableDatabase();
        //DELETE from diaries
        String sql2 = "DELETE FROM DIARIES WHERE id = ?";
        SQLiteStatement statement2 = database.compileStatement(sql2);
        statement2.clearBindings();
        statement2.bindDouble(1, (double)id);
        statement2.execute();
        database.close();
    }
    public void restoreDiary(int id){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE DIARIES SET deleted = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindDouble(1,0);
        statement.bindDouble(2,(double)id);
        statement.execute();
        database.close();
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void getAllData(){

    }
    public void insetDiary(){

    }
    public void softDelet(){

    }
    public void deletpermenantly(){

    }
    public void updateDiary(){

    }
    public void restoreDiary(){

    }
    public void favorites(){

    }
    public void setFavourites(){

    }
    public void removeFromFavourites(){

    }
}
