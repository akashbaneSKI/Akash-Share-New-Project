package com.example.database_changes.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

public class LeaklessCursorFactory implements CursorFactory {
    public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery,
        String editTable, SQLiteQuery query) {
        return new LeaklessCursor(db,masterQuery,editTable,query);
    }
}	

