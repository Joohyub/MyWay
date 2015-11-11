package com.example.mywaytest3;

import com.github.jjobes.slidedaytimepicker.SlideDayTimeListener;
import com.github.jjobes.slidedaytimepicker.SlideDayTimePicker;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WeeklyRegistrationActivity extends FragmentActivity{
	
	
	
	LinearLayout layoutWeekDay, layoutWeekTime, layoutWeekFrom, layoutWeekTo, layoutWeekTransport;
	
	TextView tvWeekDay, tvWeekTime, tvWeekFrom, tvWeekTo, tvWeekTransport;
	
	public static int day, hour, minute = 0; 
	
	public String sDay[] = new String[]{"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weeklyregistration);

		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f44336")));
		getActionBar().setIcon(
				   new ColorDrawable(getResources().getColor(android.R.color.transparent)));   
		getActionBar().setTitle("새 주간일정 등록");
		//getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		day = getIntent().getExtras().getInt("day", 0);
		hour = getIntent().getExtras().getInt("hour", 0);

		tvWeekDay = (TextView) findViewById(R.id.tvWeekDay);
		tvWeekTime = (TextView) findViewById(R.id.tvWeekTime);
		tvWeekFrom = (TextView) findViewById(R.id.tvWeekFrom);
		tvWeekTo = (TextView) findViewById(R.id.tvWeekTo);
		tvWeekTransport = (TextView) findViewById(R.id.tvWeekTransport);
		
		
		layoutWeekDay = (LinearLayout) findViewById(R.id.layoutWeekDay);
		layoutWeekTime = (LinearLayout) findViewById(R.id.layoutWeekTime);
		layoutWeekFrom = (LinearLayout) findViewById(R.id.layoutWeekFrom);
		layoutWeekTo = (LinearLayout) findViewById(R.id.layoutWeekTo);
		layoutWeekTransport = (LinearLayout) findViewById(R.id.layoutWeekTransport);
		
		
    	tvWeekDay.setText(sDay[day]);
    	tvWeekTime.setText(String.format("%s %02d:%02d", (hour >=12)?"오후":"오전", (hour > 12)?hour-12:hour, minute));
				
		
		 final SlideDayTimeListener listener = new SlideDayTimeListener() {

	            @Override
	            public void onDayTimeSet(int day, int hour, int minute)
	            {
	            	WeeklyRegistrationActivity.day = day - 1;
	            	WeeklyRegistrationActivity.hour = hour;
	            	WeeklyRegistrationActivity.minute = minute;
	            	
	            	tvWeekDay.setText(sDay[WeeklyRegistrationActivity.day]);
	            	tvWeekTime.setText(String.format("%s %02d:%02d", (hour >=12)?"오후":"오전", (hour > 12)?hour-12:hour, minute));
	            	
	            }

	            @Override
	            public void onDayTimeCancel()
	            {
	            }
	        };

	        
	        
        layoutWeekDay.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View v)
	            {
	                new SlideDayTimePicker.Builder(getSupportFragmentManager())
	                    .setListener(listener)
	                    .setInitialDay(day+1)
	                    .setInitialHour(hour)
	                    .setInitialMinute(minute)
	                    .build()
	                    .show();
	            }
	        });
        layoutWeekTime.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v)
            {
                new SlideDayTimePicker.Builder(getSupportFragmentManager())
                .setListener(listener)
                .setInitialDay(day+1)
                .setInitialHour(hour)
                .setInitialMinute(minute)
                .build()
                .show();
            }
        });

	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem)
	{       
	    onBackPressed();
	    return true;
	}
	
}
