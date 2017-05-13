package com.example.clinicalguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class DietActivity extends Activity{
	LinearLayout diet,bal;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diet_activity);
		diet=(LinearLayout)findViewById(R.id.layout1);
		bal=(LinearLayout)findViewById(R.id.layout2);
		diet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
               Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.wikihow.com/Maintain-a-Balanced-Diet"));
				
				startActivity(intent);
			}
		});
bal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.livestrong.com/article/411167-balanced-weekly-meal-plan/"));
				
				startActivity(intent);
			}
		});
	}

}
