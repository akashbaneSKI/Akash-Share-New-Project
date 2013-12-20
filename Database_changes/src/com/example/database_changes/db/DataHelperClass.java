package com.example.database_changes.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataHelperClass {
	
	
	private Context mContext;
	private static SQLiteDatabase dbinstance;
	private SyncManagerDBAdapter syncDataManager;

	public DataHelperClass(Context con, SQLiteDatabase db) {
		mContext = con;
		dbinstance = db;
	}

	public DataHelperClass(Context con) {
		mContext = con;

	}

	public void _DataHelperClass() {
		dbinstance.close();
	}

}
