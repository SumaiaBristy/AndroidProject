package com.example.clinicalguide;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Robi extends Activity{
	ListView list;
	ArrayList<String> data;
	ArrayAdapter<String>adapter;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.robi);
		
		list=(ListView)findViewById(R.id.listView1);
        data=new ArrayList<String>();
        data.add("Lab Aid Ltd.");
        data.add("United Hospital Ltd.");
        data.add("Apollo Hospital");
        data.add("Ad-din Hospital");
        
        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,
					long arg3) {
			
				// TODO Auto-generated method stub
				String selectedItem =((TextView) v).getText().toString();
	               //Intent intent =new Intent(this,this);
	              // intent.putExtra("item_name", selectedItem);
	               //startActivity(intent);
				Intent intent = new Intent(Intent.ACTION_DIAL);
				if(selectedItem.equals("Lab Aid Ltd.")){
				intent.setData(Uri.parse("tel:10606"));
				startActivity(intent); 
				}
				if(selectedItem.equals("United Hospital Ltd.")){
					intent.setData(Uri.parse("tel:10666"));
					startActivity(intent); 
					}
				if(selectedItem.equals("Apollo Hospital")){
					intent.setData(Uri.parse("tel:10678"));
					startActivity(intent); 
					}
				if(selectedItem.equals("Ad-din Hospital")){
					intent.setData(Uri.parse("tel:10610"));
					startActivity(intent); 
					}
				
			}
		});
		//String selectedItem=getIntent().getExtras().getString("item_name");
		
	}
}
