package com.gowhich.androidsqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by durban126 on 16/9/19.
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    private static String name = "mydb.db";
    private static int version = 2;

    public DbOpenHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当数据库被创建时，第一次被执行，完成对数据库表的创建
        String sql = "create table person (id integer primary key autoincrement, name varchar(45), address varchar(45))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "alter table person add sex varchar(8)";
        sqLiteDatabase.execSQL(sql);
    }
}
