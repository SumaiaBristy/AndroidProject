package com.example.clinicalguide;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class DiseaseActivity extends Activity{
	
	DataHandler handler;
	Button delete,add;
	ListView list;
	TextView text;
	String status="no";
	String selectedItem;
	ArrayList<String> data;

	ArrayAdapter<String>adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disease_activity);
		add=(Button)findViewById(R.id.button1);
		delete=(Button)findViewById(R.id.button2);
		 list=(ListView)findViewById(R.id.listView1);
	        data=new ArrayList<String>();
		handler=new DataHandler(this);
    add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                   Intent intent=new Intent(DiseaseActivity.this,AdminActivity.class);
				
				startActivity(intent);
			}
		});
   /* delete.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(DiseaseActivity.this,AdminActivity.class);
			
			startActivity(intent);
		}
	});*/
	
	Cursor cursor=handler.getAllContact();
	if(cursor.getCount()<1)
	{
		Toast.makeText(getApplicationContext(), "No data available", Toast.LENGTH_LONG).show();
	}
	else
	{
	
		cursor.moveToFirst();
		do
		{
			String name=cursor.getString(cursor.getColumnIndex(handler.CONTACT_NAME));
			//Toast.makeText(getApplicationContext(), allData, Toast.LENGTH_LONG).show();
			//data.add(name);
			//String s=String.valueOf(id);
			data.add(name);
			 adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
		        list.setAdapter(adapter);
		        list.setOnItemClickListener(new OnItemClickListener() {
		        	
		        	
					@Override
					public void onItemClick(AdapterView<?> arg0, View v, int arg2,
							long arg3) {
						
						// status="yes";
						// TODO Auto-generated method stub
						selectedItem =((TextView) v).getText().toString();
						Intent intent =new Intent(DiseaseActivity.this,TipWebActivity.class);
			               intent.putExtra("item_name", selectedItem);
			              
			               startActivity(intent);
						//Toast.makeText(getApplicationContext(),selectedItem, Toast.LENGTH_LONG).show();
                         
						
					}
				});
		    
		}
		while(cursor.moveToNext());
	}
  }
}
