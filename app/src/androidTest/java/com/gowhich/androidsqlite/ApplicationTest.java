package com.gowhich.androidsqlite;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import com.gowhich.androidsqlite.db.DbOpenHelper;

import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void create(){
        Context context = getContext();
        DbOpenHelper dbOpenHelper = new DbOpenHelper(context);
        dbOpenHelper.getWritableDatabase();
    }
}