package com.gowhich.androidsqlite;

import android.app.Application;
import android.content.ContentValues;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.gowhich.androidsqlite.dao.PersonDao2;
import com.gowhich.androidsqlite.service.PersonService2;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/9/21.
 */

public class PersonDao2Test extends ApplicationTestCase<Application> {
    public PersonDao2Test() {
        super(Application.class);
    }

    @Test
    public void insertDb(){
        PersonService2 service = new PersonDao2(getContext());
        ContentValues values = new ContentValues();
        values.put("name","李四");
        values.put("address","北京");
        values.put("sex","不祥");
        boolean flag = service.addPerson(values);
        Log.i("PersonDao2Test","insertDb ------>" + flag);
    }

    @Test
    public void deleteDb(){
        PersonService2 service = new PersonDao2(getContext());
        boolean flag = service.deletePerson(" id = ? ", new String[]{"3"});
        Log.i("PersonDao2Test","deleteDb ------>" + flag);
    }

    @Test
    public void updateDb(){
        PersonService2 service = new PersonDao2(getContext());
        ContentValues values = new ContentValues();
        values.put("name","王五");
        values.put("address","上海");
        values.put("sex","男");
        boolean flag = service.updatePerson(values, " id = ? ", new String[]{" 6 "});
        Log.i("PersonDao2Test","updateDb ------>" + flag);
    }

    @Test
    public void viewDB(){
        PersonService2 service = new PersonDao2(getContext());
        Map<String, String> map = service.viewPerson(" id = ? ", new String[]{"6"});
        Log.i("PersonDao2Test","viewDB ------>" + map.toString());
    }

    @Test
    public void listDB(){
        PersonService2 service = new PersonDao2(getContext());
        List<Map<String, String>> list = service.listPerson(null, null);
        Log.i("PersonDao2Test","listDB ------>" + list.toString());
    }

}
