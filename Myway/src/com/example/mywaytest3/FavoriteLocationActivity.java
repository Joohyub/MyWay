package com.example.mywaytest3;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class FavoriteLocationActivity extends FragmentActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favoritelocation);


		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196f3")));

		getActionBar().setIcon(
				new ColorDrawable(getResources().getColor(android.R.color.transparent)));   
		getActionBar().setTitle("즐겨 찾는 장소");
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		


	}
}
