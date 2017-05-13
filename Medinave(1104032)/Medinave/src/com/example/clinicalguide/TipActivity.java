package com.example.clinicalguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class TipActivity extends Activity{
	//Button we,he,sleep,diet;
    LinearLayout we,he,sleep,diet;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tip_activity);
		/*diet=(Button)findViewById(R.id.button1);
		sleep=(Button)findViewById(R.id.button2);
		we=(Button)findViewById(R.id.button3);
		he=(Button)findViewById(R.id.button4);*/
		diet=(LinearLayout)findViewById(R.id.layout1);
		sleep=(LinearLayout)findViewById(R.id.layout2);
		we=(LinearLayout)findViewById(R.id.layout3);
		he=(LinearLayout)findViewById(R.id.layout4);
		diet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
              Intent intent=new Intent(TipActivity.this,DietActivity.class);
				startActivity(intent);
			}
		});
sleep.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://healthysleep.med.harvard.edu/need-sleep/what-can-you-do/assess-needs"));
				
				startActivity(intent);
			}
		});
he.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.healthchecksystems.com/heightweightchart.htm"));
			
			startActivity(intent);
	}
});
we.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.healthchecksystems.com/heightweightchart.htm"));
			
			startActivity(intent);
	}
});
	
		
		
		
	}
}
