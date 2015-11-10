package com.lg.sw26a2.myway.db;

import android.content.ContentResolver;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

public class MyWayDBManager {
	
	private static MyWayDBManager instence = new MyWayDBManager();

	SQLiteDatabase db;
	
	private MyWayDBManager() {
		
	}
	
	public static MyWayDBManager getInstance(Context context){
		instence.db = (new MyWayDBHelper(context)).getWritableDatabase();
		return instence;
	}
	
	
	public void insertWeekSchedule(int dayofWeek, int time, int transport,  int from, int to)
	{
		
	}
	
	public void insertAppointment(int dayofWeek, int time, int transport,  int from, int to)
	{
		
	}
	
	public void insertLocation(String name, String location, int outtime, int type)
	{
		
	}
	
	public void updatePersonal(int id, int walkvel)
	{
		
	}	
	
	
	public void updateWeekSchdule(int id, int dayofWeek, int time, int transport,  int from, int to)
	{
		
	}
	
	public void updateAppointment(int id, int dayofWeek, int time, int transport,  int from, int to)
	{
		
	}	
	
	public void updateLocation(int id, String name, String location, int outtime, int type)
	{
		
	}
	
	public void deleteWeekSchdule(int id)
	{
		
	}
	
	public void deleteLocation(int id)
	{
		
	}		
	
	public Cursor searchWeekSchedule()
	{
		Cursor c = null;
		return c;
	}
	public Cursor searchAppointment()
	{
		Cursor c = null;
		return c;
	}
	public Cursor searchLocation()
	{
		Cursor c = null;
		return c;
	}
	
	
	
	
	
}
