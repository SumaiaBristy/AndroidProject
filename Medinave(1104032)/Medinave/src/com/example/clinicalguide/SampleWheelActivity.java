package com.example.clinicalguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

//import com.digitalaria.gama.wheel.Wheel;

public class SampleWheelActivity extends Activity{
	   LinearLayout hos,near,tele,bld,amb,diag,sense,com,shake,about,guide;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        hos=(LinearLayout)findViewById(R.id.layout1);
        near=(LinearLayout)findViewById(R.id.layout2);
        tele=(LinearLayout)findViewById(R.id.layout3);
        amb=(LinearLayout)findViewById(R.id.layout4);
        bld=(LinearLayout)findViewById(R.id.layout5);
        diag=(LinearLayout)findViewById(R.id.layout6);
        shake=(LinearLayout)findViewById(R.id.layout7);
        com=(LinearLayout)findViewById(R.id.layout8);
        sense=(LinearLayout)findViewById(R.id.layout9);
        guide=(LinearLayout)findViewById(R.id.layout10);
        about=(LinearLayout)findViewById(R.id.layout11);
        hos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent=new Intent(SampleWheelActivity.this,AndroidListViewCustomLayoutActivity.class);
				startActivity(intent);
				
				
			}
		});
hos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent=new Intent(SampleWheelActivity.this,AndroidListViewCustomLayoutActivity.class);
				startActivity(intent);
				
				
			}
		});

near.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
    	
    	LayoutInflater li=LayoutInflater.from(SampleWheelActivity.this);
		   View view1=li.inflate(R.layout.custom_layout1,null);
		 
		
		   LinearLayout cont =(LinearLayout)view1.findViewById(R.id.layout1);
		   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout2);
		
		   
			AlertDialog.Builder builder=new AlertDialog.Builder(SampleWheelActivity.this);
			builder.setView(view1);//builder e age image set krtam ekhn view set korlam
			builder.setCancelable(false);
			final AlertDialog customdialog=builder.create();
			customdialog.show();
		
		
		
		
		
		
           cont.setOnClickListener(new OnClickListener() {
       			
       			@Override
       			public void onClick(View arg0) {
       				
       				Intent intent=new Intent(SampleWheelActivity.this,NearestHos.class);
  	           
  	               startActivity(intent);
       				
       				
       			}
       		});
		
           close.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   				//Toast.makeText(getApplicationContext(),"dialog cancelled",Toast.LENGTH_LONG).show();
   				customdialog.cancel();
   				
   				
   			}
   		});
		
		
	}
});
tele.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		

    	Intent intent=new Intent(SampleWheelActivity.this,CallActivity.class);
		startActivity(intent);
		
		
	}
});
amb.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent(SampleWheelActivity.this,AndroidListViewCustomLayoutActivity3.class);
		startActivity(intent);
		
		
	}
});
bld.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent(SampleWheelActivity.this,AndroidListViewCustomLayoutActivity1.class);
		startActivity(intent);
		
		
	}
});
diag.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent(SampleWheelActivity.this,AndroidListViewCustomLayoutActivity2.class);
		startActivity(intent);
		
		
	}
});
shake.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent(SampleWheelActivity.this,MainAccelerometer.class);
		startActivity(intent);
		
		
	}
});
com.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent(SampleWheelActivity.this,Community.class);
		startActivity(intent);
		
		
	}
});
sense.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent(SampleWheelActivity.this,Sense.class);
		startActivity(intent);
		
		
	}
});
about.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
    	LayoutInflater li=LayoutInflater.from(SampleWheelActivity.this);
		   View view1=li.inflate(R.layout.about,null);
		   LinearLayout close=(LinearLayout)view1.findViewById(R.id.layout2);
			AlertDialog.Builder builder=new AlertDialog.Builder(SampleWheelActivity.this);
			builder.setView(view1);//builder e age image set krtam ekhn view set korlam
			builder.setCancelable(false);
			final AlertDialog customdialog=builder.create();
			customdialog.show();
		
           close.setOnClickListener(new OnClickListener() {
   			
   			@Override
   			public void onClick(View arg0) {
   				// TODO Auto-generated method stub
   				//Toast.makeText(getApplicationContext(),"dialog cancelled",Toast.LENGTH_LONG).show();
   				customdialog.cancel();
   				
   				
   			}
   		});
    	
		
	}
});

guide.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		
		Intent intent=new Intent(SampleWheelActivity.this,User.class);
		startActivity(intent);
		
		
	}
});

       
        
    }

    
    
}
	
    
