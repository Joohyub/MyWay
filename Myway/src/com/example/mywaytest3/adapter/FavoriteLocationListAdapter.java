package com.example.mywaytest3.adapter;

import java.util.ArrayList;

import com.example.mywaytest3.R;
import com.example.mywaytest3.model.AppointmentItem;
import com.example.mywaytest3.model.LocationItem;
import com.example.mywaytest3.model.LocationManager;
import com.example.mywaytest3.model.NavDrawerItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FavoriteLocationListAdapter extends BaseAdapter {

	private LocationManager lm = LocationManager.getInstance();
	private Context context;
	private ArrayList<LocationItem> locationItems;
	
	public FavoriteLocationListAdapter(Context context, ArrayList<LocationItem> items){
		this.context = context;
		this.locationItems = items;
	}

	@Override
	public int getCount() {
		return locationItems.size();
	}

	@Override
	public Object getItem(int position) {		
		return locationItems.get(position);
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
            convertView = mInflater.inflate(R.layout.item_location_card, null);
        }
         
        TextView itemtvLocation = (TextView) convertView.findViewById(R.id.itemtvLocation);
        TextView itemtvName = (TextView) convertView.findViewById(R.id.itemtvName);
        TextView itemtvTakingTime = (TextView) convertView.findViewById(R.id.itemtvTakingTime);
        Button btnDelete = (Button) convertView.findViewById(R.id.btnDelete);
        
        btnDelete.setTag(position + "");
        
        itemtvName.setText(locationItems.get(position).getName());
        itemtvLocation.setText(locationItems.get(position).getAddress());
        itemtvTakingTime.setText("1층 내려가는 시간 : " + locationItems.get(position).getOuttime() + "분");
        
        
        btnDelete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				lm.deleteItem( Integer.parseInt(v.getTag().toString()));
			}
		});
        
     
        return convertView;
	}

}
