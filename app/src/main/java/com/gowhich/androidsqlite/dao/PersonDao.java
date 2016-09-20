package com.gowhich.androidsqlite.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gowhich.androidsqlite.db.DbOpenHelper;
import com.gowhich.androidsqlite.service.PersonService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/9/20.
 */
public class PersonDao implements PersonService {

    private DbOpenHelper helper = null;

    public PersonDao(Context context){
        helper = new DbOpenHelper(context);
    }

    @Override
    public boolean addPerson(Object[] params) {

        boolean flag = false;

        //实现对数据库的添加删除和修改
        SQLiteDatabase database = null;

        try{
            String sql = "insert into person (name, address, sex) values (?,?,?)";
            database = helper.getWritableDatabase();
            database.execSQL(sql, params);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null){
                database.close();
            }
        }

        return flag;
    }

    @Override
    public boolean deletePerson(Object[] params) {

        boolean flag = false;

        //实现对数据库的添加删除和修改
        SQLiteDatabase database = null;

        try{
            String sql = "delete from person where id = ?";
            database = helper.getWritableDatabase();
            database.execSQL(sql, params);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null){
                database.close();
            }
        }

        return flag;
    }

    @Override
    public boolean updatePerson(Object[] params) {
        boolean flag = false;

        //实现对数据库的添加删除和修改
        SQLiteDatabase database = null;

        try{
            String sql = "update person set name = ?, address = ?, sex = ? where id = ?";
            database = helper.getWritableDatabase();
            database.execSQL(sql, params);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null){
                database.close();
            }
        }

        return flag;
    }

    @Override
    public Map<String, String> viewPerson(String[] args) {

        Map<String, String> map = new HashMap<String, String>();

        //实现对数据库的添加删除和修改
        SQLiteDatabase database = null;

        try{
            String sql = "select * from person where id = ?";
            database = helper.getReadableDatabase();
            Cursor cursor = database.rawQuery(sql, args);

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


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(database != null){
                database.close();
            }
        }


        return map;
    }

    @Override
    public List<Map<String, String>> listPerson(String[] args) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        //实现对数据库的添加删除和修改
        SQLiteDatabase database = null;

        try{
            String sql = "select * from person";
            database = helper.getReadableDatabase();
            Cursor cursor = database.rawQuery(sql, args);

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
