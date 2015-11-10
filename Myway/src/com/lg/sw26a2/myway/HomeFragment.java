package com.lg.sw26a2.myway;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeFragment extends Fragment {
	
	protected  View mView;
	public static ImageButton btnDrawer, btnSearch;
	
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		MainActivity.actionBar.hide();
 
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		this.mView = rootView;
		
//		btnSearch = (Button) mView.findViewById(R.id.btnSearch);
        
        return rootView;
    }
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		btnDrawer = (ImageButton) getView().findViewById(R.id.btnDrawer);
		
		btnDrawer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});
	}
}
