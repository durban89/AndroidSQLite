package com.gowhich.androidsqlite;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import com.gowhich.androidsqlite.dao.PersonDao;
import com.gowhich.androidsqlite.db.DbOpenHelper;
import com.gowhich.androidsqlite.service.PersonService;

import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void createDb(){
        Context context = getContext();
        DbOpenHelper dbOpenHelper = new DbOpenHelper(context);
        dbOpenHelper.getWritableDatabase();
    }

    @Test
    public void insertDb(){
        PersonService service = new PersonDao(getContext());
        Object[] params = {"张三","上海","男"};
        boolean flag = service.addPerson(params);
        System.out.println("insertDb ------>" + flag);
    }

    @Test
    public void deleteDb(){
        PersonService service = new PersonDao(getContext());
        Object[] params = {"1"};
        boolean flag = service.deletePerson(params);
        System.out.println("deleteDb ------>" + flag);
    }

    @Test
    public void updateDb(){
        PersonService service = new PersonDao(getContext());
        Object[] params = {"王五","上海","男","2"};
        boolean flag = service.updatePerson(params);
        System.out.println("updateDb ------>" + flag);
    }

    @Test
    public void viewDB(){
        PersonService service = new PersonDao(getContext());
        String[] params = {"2"};
        Map<String, String> map = service.viewPerson(params);
        System.out.println("viewDB ------>" + map.toString());
    }

    @Test
    public void listDB(){
        PersonService service = new PersonDao(getContext());
        String[] params = {"1"};
        List<Map<String, String>> list = service.listPerson(null);
        System.out.println("listDB ------>" + list.toString());
    }
}