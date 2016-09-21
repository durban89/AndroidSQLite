package com.gowhich.androidsqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gowhich.androidsqlite.db.DbOpenHelper;
import com.gowhich.androidsqlite.service.PersonService2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/9/21.
 */

public class PersonDao2 implements PersonService2 {

    private DbOpenHelper helper = null;

    public PersonDao2(Context context){
        helper = new DbOpenHelper(context);
    }

    @Override
    public boolean addPerson(ContentValues values) {

        boolean flag = false;
        SQLiteDatabase database = null;
        long id = -1;
        try{
            database = helper.getWritableDatabase();
            id = database.insert("person", null, values);
            flag = (id != -1 ? true : false);
        }catch(Exception e){

        }finally {
            if(database != null){
                database.close();
            }
        }

        return flag;
    }

    @Override
    public boolean deletePerson(String whereClause, String[] whereArgs) {
        boolean flag = false;
        SQLiteDatabase database = null;
        int count = 0;
        try{
            database = helper.getWritableDatabase();
            count = database.delete("person", whereClause, whereArgs);
            flag = (count > 0 ? true : false);
        }catch(Exception e){

        }finally {
            if(database != null){
                database.close();
            }
        }

        return flag;
    }

    @Override
    public boolean updatePerson(ContentValues values, String whereClause, String[] whereArgs) {
        boolean flag = false;
        SQLiteDatabase database = null;
        int count = 0;//影响数据库的行数
        try{
            database = helper.getWritableDatabase();
            count = database.update("person", values, whereClause, whereArgs);
            flag = (count > 0 ? true : false);
        }catch(Exception e){

        }finally {
            if(database != null){
                database.close();
            }
        }

        return flag;
    }

    @Override
    public Map<String, String> viewPerson(String selection, String[] selectionArgs) {
        boolean flag = false;
        SQLiteDatabase database = null;
        Cursor cursor = null;
        Map<String, String> map = new HashMap<String, String>();

        int count = 0;//影响数据库的行数
        try{
            database = helper.getReadableDatabase();
            cursor = database.query(true, "person", null, selection, selectionArgs, null, null, null, null);
            int columns = cursor.getColumnCount();
            while (cursor.moveToNext()){
                for(int i = 0; i < columns; i++){
                    String colsName = cursor.getColumnName(i);
                    String colsValue = cursor.getString(cursor.getColumnIndex(colsName));
                    if(colsValue == null){
                        colsValue = "";
                    }

                    map.put(colsName, colsValue);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(database != null){
                database.close();
            }
        }

        return map;
    }

    @Override
    public List<Map<String, String>> listPerson(String selection, String[] selectionArgs) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        //实现对数据库的添加删除和修改
        SQLiteDatabase database = null;

        try{
            String sql = "select * from person";
            database = helper.getReadableDatabase();
            Cursor cursor = database.query(false, "person", null, selection, selectionArgs, null, null, null, null);

            int columns = cursor.getColumnCount();
            while (cursor.moveToNext()){
                Map<String, String> map = new HashMap<String, String>();
                for(int i = 0; i < columns; i++){
                    String colsName = cursor.getColumnName(i);
                    String colsValue = cursor.getString(cursor.getColumnIndex(colsName));
                    if(colsValue == null){
                        colsValue = "";
                    }

                    map.put(colsName, colsValue);
                }
                list.add(map);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null){
                database.close();
            }
        }


        return list;
    }
}
