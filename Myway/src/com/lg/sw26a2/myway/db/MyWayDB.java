package com.lg.sw26a2.myway.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MyWayDB extends SQLiteOpenHelper{
	public static final String DB_NAME = "myway.db";
	public static final String DB_TABLE1 = "personal";
	public static final String DB_TABLE2 = "location";
	public static final String DB_TABLE3 = "appointment";	
	public static final String DB_TABLE4 = "weekschedule";	
	
	public MyWayDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public MyWayDB(Context context) {
		super(context, DB_NAME, null, 1);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE1 + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, walkvel TEXT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE2 + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, location TEXT, outtime INT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE3 + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date INT, time INT, transport INT, from INT, to INT, FOREIGN KEY (from) REFERENCES DB_TABLE2(_id), FOREIGN KEY (to) REFERENCES DB_TABLE2(_id));");
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE3 + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date INT, time INT, transport INT, from INT, to INT, FOREIGN KEY (from) REFERENCES DB_TABLE2(_id), FOREIGN KEY (to) REFERENCES DB_TABLE2(_id));");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE1);
		db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE2);
		onCreate(db);
	}
}
