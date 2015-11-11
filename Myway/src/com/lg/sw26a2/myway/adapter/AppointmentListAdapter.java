package com.lg.sw26a2.myway.adapter;

import java.util.ArrayList;

import com.lg.sw26a2.myway.R;
import com.lg.sw26a2.myway.model.AppointmentItem;
import com.lg.sw26a2.myway.model.NavDrawerItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AppointmentListAdapter extends BaseAdapter {

	
	private Context context;
	private ArrayList<AppointmentItem> appointmentItems;
	
	public AppointmentListAdapter(Context context, ArrayList<AppointmentItem> items){
		this.context = context;
		this.appointmentItems = items;
	}

	@Override
	public int getCount() {
		return appointmentItems.size();
	}

	@Override
	public Object getItem(int position) {		
		return appointmentItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_listcard, null);
        }
         
        TextView itemtvDateTime = (TextView) convertView.findViewById(R.id.itemtvDateTime);
        TextView itemtvLocation = (TextView) convertView.findViewById(R.id.itemtvLocation);
        TextView itemtvName = (TextView) convertView.findViewById(R.id.itemtvName);
        TextView itemtvTakingTime = (TextView) convertView.findViewById(R.id.itemtvTakingTime);
        
        itemtvName.setText(appointmentItems.get(position).name);
        itemtvLocation.setText(appointmentItems.get(position).address);
        itemtvDateTime.setText(appointmentItems.get(position).data/10000 + "/" + (appointmentItems.get(position).data/100)%100 + "/" + appointmentItems.get(position).data%100 + " " + appointmentItems.get(position).time/100 + ":" + appointmentItems.get(position).time%100);
        itemtvTakingTime.setText("예상 소요시간 : " + appointmentItems.get(position).estimatedTime + "분");
        
     
        return convertView;
	}

}
