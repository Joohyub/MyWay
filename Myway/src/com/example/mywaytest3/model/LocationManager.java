package com.example.mywaytest3.model;

import java.util.ArrayList;

import com.example.mywaytest3.db.MyWayDBManager;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;


public class LocationManager {
		private static LocationManager instance = new LocationManager();
		private ArrayList<LocationItem> llist = new ArrayList<LocationItem>();	
		
		private LocationManager() {
			super();
		}
		public static LocationManager getInstance(){
			return instance;
		}
		
		public static void init(Context context){
			MyWayDBManager DBman;
			DBman = MyWayDBManager.getInstance(context);
			Cursor c = DBman.searchLocation();
			while(c.moveToNext()){
				int id = c.getInt(0);
				String name = c.getString(1);
				String address = c.getString(2);
				float x = c.getFloat(3);
				float y = c.getFloat(4);
				int outtime = c.getInt(5);
				int type = c.getInt(6);
				instance.addItem(id, name, address, x, y, outtime, type);
			}

		}
		
		public void addItem(int id, String name, String address, float x, float y, int outtime, int type){
			LocationItem item = null;
			item = new LocationItem();
			item.setId(id);
			item.setName(name);
			item.setAddress(address);
			item.setX(x);
			item.setY(y);
			item.setOuttime(outtime);
			item.setType(type);
			llist.add(item);
		}
		
		public void updateItem(int id, String name, String address, float x, float y, int outtime, int type){
			for(LocationItem w : llist){
				if(w.getId() == id){
					w.setName(name);
					w.setAddress(address);
					w.setOuttime(outtime);
					w.setType(type);
					w.setX(x);
					w.setY(y);
					return;
				}
			}
		}
		
		public void deleteItem(int id){
			for(LocationItem l : llist){
				if(l.getId() == id){
					llist.remove(l);
				}
			}
		}
		
		public float getLocationX(int id){
			for(LocationItem l : llist){
				if(l.getId() == id){
					return l.getX();
				}
			}
			return 0;
		}
		
		public float getLocationY(int id){
			for(LocationItem l : llist){
				if(l.getId() == id){
					return l.getY();
				}
			}
			return 0;
		}
		
		public int getLocationOuttime(int id){
			for(LocationItem l : llist){
				if(l.getId() == id){
					return l.getOuttime();
				}
			}
			return 0;
		}
		
		public int getLocationType(int id){
			for(LocationItem l : llist){
				if(l.getId() == id){
					return l.getType();
				}
			}
			return 0;
		}
		
		public int listsize(){
			return llist.size();
		}
		
		public void printlist(){
			for(LocationItem l : llist){
				Log.e("ploc",l.getId()+" "+l.getName()+" "+l.getAddress()+" "+l.getX()+" "+l.getY()+" "+l.getOuttime()+" "+l.getType()); 
			}
		}
		
		public String getLocationAddress(int id){
			for(LocationItem litem : llist){
				if(litem.getId() == id){
					return litem.getAddress(); 
				}
			}
			return null;
		}
		
		public String getLocationName(int id){
			for(LocationItem litem : llist){
				if(litem.getId() == id){
					return litem.getName(); 
				}
			}
			return null;
		}
}
