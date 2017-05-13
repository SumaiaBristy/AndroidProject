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

public class Sense extends Activity{
	ListView list;
	ArrayList<String> data;
	ArrayAdapter<String>adapter;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sense);
		
		list=(ListView)findViewById(R.id.listView1);
        data=new ArrayList<String>();
        data.add("Check Your BMI");
        data.add("First Aid");
        data.add("Vaccine");
        data.add("Myth");
        data.add("Tips");
        
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
			
				if(selectedItem.equals("Check Your BMI")){
					Intent in=new Intent(Sense.this,CalculatorActivity.class);
					startActivity(in); 
					
					}
				if(selectedItem.equals("First Aid")){
					Intent in=new Intent(Sense.this,StepActivity.class);
					startActivity(in);  
					}
				if(selectedItem.equals("Vaccine")){
					Intent in=new Intent(Sense.this,vaccinActivity.class);
					startActivity(in);
					
					} 
				if(selectedItem.equals("Myth")){
					Intent in=new Intent(Sense.this,MythActivity.class);
					startActivity(in); 
					
					}
				if(selectedItem.equals("Tips")){
					Intent in=new Intent(Sense.this,TipActivity.class);
					startActivity(in);
					
					}
				
				
				
			}
		});
		//String selectedItem=getIntent().getExtras().getString("item_name");
		
	}
}
