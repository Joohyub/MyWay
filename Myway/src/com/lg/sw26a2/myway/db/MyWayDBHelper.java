package com.lg.sw26a2.myway.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MyWayDBHelper extends SQLiteOpenHelper{
	public static final String DB_NAME = "myway.db";
	public static final String DB_TABLE_PERSONAL = "personal";
	public static final String DB_TABLE_LOCATION = "location";
	public static final String DB_TABLE_APPOINTMENT = "appointment";	
	public static final String DB_TABLE_WEEKLY = "weekschedule";	
	
	public MyWayDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public MyWayDBHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE_PERSONAL + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, walkvel INT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE_LOCATION + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, location TEXT, outtime INT, type INT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE_APPOINTMENT + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date INT, time INT, transport INT, from INT, to INT, FOREIGN KEY (from) REFERENCES DB_TABLE2(_id), FOREIGN KEY (to) REFERENCES DB_TABLE2(_id));");
		db.execSQL("CREATE TABLE IF NOT EXISTS "+ DB_TABLE_WEEKLY + 
				" (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, dayofweek INT, time INT, transport INT, from INT, to INT, FOREIGN KEY (from) REFERENCES DB_TABLE2(_id), FOREIGN KEY (to) REFERENCES DB_TABLE2(_id));");
	
		ContentValues cv = new ContentValues();
		
		cv.put("walkvel", 0);
		db.insert(DB_TABLE_PERSONAL,null,cv);
		
		cv.clear();
		cv.put("name","집");
		cv.put("location","서울시 동작구 흑석동");
		cv.put("outtime","7");
		cv.put("type","1");
		db.insert(DB_TABLE_LOCATION, null, cv);
		
		cv.put("name","회사");
		cv.put("location","서울시 금천구 디지털로 10길 56");
		cv.put("outtime","15");
		cv.put("type","1");
		db.insert(DB_TABLE_LOCATION, null, cv);
		
		cv.put("name","연구실");
		cv.put("location","서울시 동작구 흑석동 중앙대 제2공");
		cv.put("outtime","7");
		db.insert(DB_TABLE_LOCATION, null, cv);
		
		cv.put("name","알바");
		cv.put("location","서울시 금천구 독산동");
		cv.put("outtime","7");
		cv.put("type","1");
		db.insert(DB_TABLE_LOCATION, null, cv);
		
		cv.put("name","강남역");
		cv.put("location","서울시 강남구 강남대로 396");
		cv.put("outtime","7");
		db.insert(DB_TABLE_LOCATION, null, cv);
		
		
	
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_PERSONAL);
		db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_LOCATION);
		db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_APPOINTMENT);
		db.execSQL("DROP TABLE IF EXISTS "+ DB_TABLE_WEEKLY);
		onCreate(db);
	}
}
