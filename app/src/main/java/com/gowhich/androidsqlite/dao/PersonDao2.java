package com.gowhich.androidsqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.gowhich.androidsqlite.db.DbOpenHelper;
import com.gowhich.androidsqlite.service.PersonService2;

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
    public boolean addPerson(Object[] params) {

        boolean flag = false;
        SQLiteDatabase database = null;
        long id = -1;
        try{
            database = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name","person1");
            values.put("address","adress1");
            values.put("sex","sex1");

            id = database.insert("person", null, values);

            flag = (id != -1 ? true : false);

        }catch(Exception e){
            if(database != null){
                database.close();
            }
        }

        return flag;
    }

    @Override
    public boolean deletePerson(Object[] params) {
        return false;
    }

    @Override
    public boolean updatePerson(Object[] params) {
        return false;
    }

    @Override
    public Map<String, String> viewPerson(String[] args) {
        return null;
    }

    @Override
    public List<Map<String, String>> listPerson(String[] args) {
        return null;
    }
}
