package com.lg.sw26a2.myway.model;

public class AppointmentItem {
	
	public String name;
	public int data;
	public int time;
	public String location;
	public String address;
	public int estimatedTime;
	
	public AppointmentItem(String name, int data, int time, String location,
			String address, int estimatedTime) {
		super();
		this.name = name;
		this.data = data;
		this.time = time;
		this.location = location;
		this.address = address;
		this.estimatedTime = estimatedTime;
	}
	
	
	
}
