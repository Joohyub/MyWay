package com.lg.sw26a2.myway;


import java.util.ArrayList;
import java.util.List;

import com.lg.sw26a2.myway.adapter.AppointmentListAdapter;
import com.lg.sw26a2.myway.model.*;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class HomeFragment extends Fragment {
	
	protected  View mView;
	public static ImageButton btnDrawer, btnSearch;
	public EditText etSearchKey;
	
	
	
	//Dummy code
	public ArrayList<AppointmentItem> list = new ArrayList<AppointmentItem>();
	
	public ListView lv;
	
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		MainActivity.actionBar.hide();
 
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		this.mView = rootView;
		
		list.add(new AppointmentItem("소개팅", 20151111, 1800, "강남역", "서울시 강남구 강남대로 396", 40));
		
		
		

        return rootView;
    }
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		etSearchKey = (EditText) getView().findViewById(R.id.etSearchKey);
		btnDrawer = (ImageButton) getView().findViewById(R.id.btnDrawer);
		btnSearch = (ImageButton) getView().findViewById(R.id.btnSearch);		
		lv = (ListView) getView().findViewById(R.id.lvCommingEvent);
		
		btnDrawer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MainActivity.mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});

		
		lv.setAdapter(new AppointmentListAdapter(getActivity(), list));
		
		
	}
}
