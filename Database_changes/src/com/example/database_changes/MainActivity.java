package com.example.database_changes;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

import com.example.database_changes.db.Internet;
import com.example.database_changes.db.SyncManagerDBAdapter;

public class MainActivity extends Activity {

	SyncManagerDBAdapter databaseManager;
	SQLiteDatabase sqdb;

	String[] names = { "Sachin", "Shruthi", "Ashish", "Akshay", "Ashwini",
			"Anish", "Akash" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		databaseManager = SyncManagerDBAdapter
				.getSharedObject(MainActivity.this);

		sqdb = databaseManager.getWritableDatabase();
		sqdb.beginTransaction();

		// "CREATE TABLE sample_table(localid INTEGER PRIMARY KEY,sample_id INTEGER NULL,sample_name TEXT NULL)"

		ContentValues cv = new ContentValues();
		cv.put("sample_id", "" + 100);

		cv.put("sample_name", "new_name");
		cv.put("sample_altered_column", "new_column");

		sqdb.insertOrThrow("sample_table", null, cv);

		sqdb.setTransactionSuccessful();
		sqdb.endTransaction();
		sqdb.close();
		databaseManager.close();

		Internet.pulldb();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
