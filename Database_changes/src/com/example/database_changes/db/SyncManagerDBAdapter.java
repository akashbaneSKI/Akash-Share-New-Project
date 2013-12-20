package com.example.database_changes.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SyncManagerDBAdapter extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "database_changes.db";
	private static final int DATABASE_VERSION = 1;
	private static SyncManagerDBAdapter instance;
	public static String Lock = "dblock";
	public Context context;

	public static SyncManagerDBAdapter getSharedObject(Context context) {
		if (instance == null) {
			instance = new SyncManagerDBAdapter(context);
		}
		instance.context = context;
		return instance;
	}

	public SyncManagerDBAdapter(Context context) {

		super(context, DATABASE_NAME, new LeaklessCursorFactory(),
				DATABASE_VERSION);
	}

	public SQLiteDatabase getWritableDatabase() {
		SQLiteDatabase sqdb = super.getWritableDatabase();

		sqdb.setLockingEnabled(true);
		return sqdb;
	}

	public SQLiteDatabase getReadableDatabase() {
		return super.getReadableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE ba_tbl_user(localid INTEGER NULL,id INTEGER PRIMARY KEY,email TEXT NULL,password TEXT NULL,f_name TEXT NULL,l_name TEXT NULL,device TEXT NULL,last_login TEXT NULL,active INTEGER NULL,created_date TEXT NULL,verification_key TEXT NULL,active_date TEXT NULL,old_password TEXT NULL,last_modified TEXT NULL,created_by TEXT NULL,subscribtion_type TEXT NULL,user_type TEXT NULL)");
		db.execSQL("CREATE TABLE ba_tbl_vendor(localid INTEGER NULL,id INTEGER PRIMARY KEY,vendor_name TEXT NULL,user_id TEXT NULL,tags TEXT NULL,alias TEXT NULL,description TEXT NULL,website INTEGER NULL,path TEXT NULL,created_date TEXT NULL,security_pin TEXT NULL,old_security_pin TEXT NULL,last_modified_security_pin TEXT NULL,geo_latitude TEXT NULL,geo_longitude TEXT NULL,last_modified_date TEXT NULL,is_deleted INTEGER NULL,delete_date TEXT NULL)");
		db.execSQL("CREATE TABLE ba_tbl_user_type_master(localid INTEGER NULL,id INTEGER PRIMARY KEY,user_type TEXT NULL,created_date TEXT NULL,is_deleted INTEGER NULL,last_modified TEXT NULL)");
		db.execSQL("CREATE TABLE ba_tbl_plan_master(localid INTEGER NULL,id INTEGER PRIMARY KEY,plan TEXT NULL,created_date TEXT NULL,active INTEGER NULL,last_modified TEXT NULL,plan_tags INTEGER NULL,size_allocated REAL NULL)");
		db.execSQL("CREATE TABLE ba_tbl_content(localid INTEGER NULL,id INTEGER PRIMARY KEY,content_name TEXT NULL,vendor_id TEXT NULL,tags TEXT NULL,title TEXT NULL,content_size REAL NULL,description TEXT NULL,website TEXT NULL,created_date TEXT NULL,update_date TEXT NULL,is_deleted INTEGER NULL,delete_date TEXT NULL)");
		db.execSQL("CREATE TABLE ba_tbl_feature_master(localid INTEGER NULL,id INTEGER PRIMARY KEY,feature TEXT NULL,created_date TEXT NULL,active INTEGER NULL,last_modified TEXT NULL)");
		db.execSQL("CREATE TABLE ba_tbl_vendor_share(localid INTEGER NULL,id INTEGER PRIMARY KEY,vendor_id TEXT NULL,share_with TEXT NULL,share_date TEXT NULL,description TEXT NULL,share_remove_date TEXT NULL,share_email TEXT NULL)");
		db.execSQL("CREATE TABLE ba_tbl_feature_plan(localid INTEGER NULL,id INTEGER PRIMARY KEY,feature_id TEXT NULL,plan_id TEXT NULL,created_date TEXT NULL,active INTEGER NULL,last_modied TEXT NULL)");
		db.execSQL("CREATE TABLE ba_tbl_plan_user(localid INTEGER NULL,id INTEGER PRIMARY KEY,plan_id TEXT NULL,user_id TEXT NULL,created_date TEXT NULL,active INTEGER NULL,last_modied TEXT NULL)");
		db.execSQL("CREATE TABLE tbl_user_history(localid INTEGER NULL,id INTEGER PRIMARY KEY,user_id TEXT NULL,action TEXT NULL,timestamp TEXT NULL)");

	}

	public void clearDB() {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// String sql = "ALTER TABLE " + "sample_table" + " ADD COLUMN "
		// + "sample_altered_column TEXT NULL";
		// db.execSQL(sql);
	}

}
