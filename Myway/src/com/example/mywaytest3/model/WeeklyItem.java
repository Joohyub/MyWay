package com.example.mywaytest3.model;

public class WeeklyItem {
	private int id;
	private String name;
	private int dayofweek;
	private int time;
	private int transport;
	private int from;
	private int to;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDayofweek() {
		return dayofweek;
	}
	
	public void setDayofweek(int dayofweek) {
		this.dayofweek = dayofweek;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getTransport() {
		return transport;
	}
	
	public void setTransport(int transport) {
		this.transport = transport;
	}
	
	public int getFrom() {
		return from;
	}
	
	public void setFrom(int from) {
		this.from = from;
	}
	
	public int getTo() {
		return to;
	}
	
	public void setTo(int to) {
		this.to = to;
	}
	
}
