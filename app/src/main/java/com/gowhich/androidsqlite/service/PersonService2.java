package com.gowhich.androidsqlite.service;

import android.content.ContentValues;

import java.util.List;
import java.util.Map;

/**
 * Created by durban126 on 16/9/21.
 */

public interface PersonService2 {
    public boolean addPerson(ContentValues params);

    public boolean deletePerson(String whereClause, String[] whereArgs);

    public boolean updatePerson(ContentValues values, String whereClause, String[] whereArgs);

    public Map<String, String> viewPerson(String selection, String[] selectionArgs);

    public List<Map<String, String>> listPerson(String selection, String[] selectionArgs);
}
