package com.lg.sw26a2.myway;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;

public class HomeFragment extends Fragment {

	public static Button btnDrawer;
	public static Button btnSearch;

	public HomeFragment() {}

	public View OnCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);

		btnDrawer = (Button) rootView.findViewById(R.id.btnDrawer);
		btnDrawer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


			}
		});
		btnSearch = (Button) getView().findViewById(R.id.btnSearch);

		return rootView;
	}
}
