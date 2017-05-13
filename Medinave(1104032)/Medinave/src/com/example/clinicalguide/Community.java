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

public class Community extends Activity{
	ListView list;
	ArrayList<String> data;
	ArrayAdapter<String>adapter;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.community);
		
		list=(ListView)findViewById(R.id.listView1);
        data=new ArrayList<String>();
        data.add("Chittagong medical services");
        data.add("Donating blood Community");
        data.add("Blood bank");
        data.add("Doctorsbd.com");
        data.add("Red Drop online blood bank");
        data.add("Robi emergency helpline");
        data.add("GP emergency helpline");      
        data.add("Banglalink emergency helpline"); 
        data.add("Airtel emergency helpline");
        data.add("Emergency Blood,Hospital,Ambulance helpline");
        data.add("First Aid and emergency treatments");
        data.add("Blood bank in different division");
        
        
        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int arg2,
					long arg3) {
			
				// TODO Auto-generated method stub
				String selectedItem =((TextView) v).getText().toString();
				 Intent intent =new Intent(Community.this,TipWebActivity.class);
				 intent.putExtra("item_name", selectedItem);
	               startActivity(intent);
				
				
				
			}
		});
		//String selectedItem=getIntent().getExtras().getString("item_name");
		
	}
}
