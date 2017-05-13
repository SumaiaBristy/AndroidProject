package com.example.clinicalguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HospitalActivity extends Activity{
	Button showMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hospital_layout);
		showMap=(Button)findViewById(R.id.button1);
showMap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(HospitalActivity.this,AndroidListViewCustomLayoutActivity.class);
				startActivity(in);
				
			}
		});
	}
	
}
