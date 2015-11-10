package com.lg.sw26a2.myway;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PersonalSettingFragment extends Fragment {
	
	public PersonalSettingFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		MainActivity.actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2196f3")));
		MainActivity.actionBar.show();
		
        View rootView = inflater.inflate(R.layout.fragment_personalsetting, container, false);
         
        return rootView;
    }
}
