package com.example.clinicalguide;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
 
public class MainAccelerometer extends Activity implements AccelerometerListener{
	DataHandler handler;
	private DbHelper mHelper;
	private SQLiteDatabase dataBase;

	LinearLayout add,del,show,sms;
	String status="no";
	String selectedItem,phn,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
     
		
         sms = (LinearLayout) findViewById(R.id.layout1); 
         add= (LinearLayout) findViewById(R.id.layout2); 
        del = (LinearLayout) findViewById(R.id.layout3); 
        show = (LinearLayout) findViewById(R.id.layout4); 
        mHelper = new DbHelper(this);
        handler=new DataHandler(this);
        
        
        add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				
				Intent in=new Intent(MainAccelerometer.this,AddActivity.class);
	               startActivity(in);
			}
		});
        
 show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent in=new Intent(MainAccelerometer.this,DisplayActivity.class);
	               startActivity(in);
			}
		});

 del.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			Intent in=new Intent(MainAccelerometer.this,DeleteNum.class);
            startActivity(in);
		}
	});
 
 sms.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			
			Intent in=new Intent(MainAccelerometer.this,Sms.class);
         startActivity(in);
		}
	});
       
  
 }
	
	
    @Override
	public void onAccelerationChanged(float x, float y, float z) {
		// TODO Auto-generated method stub
		
	}


    public void onShake(float force) {
        
        // Do your stuff here
         
        // Called when Motion Detected
       //Toast.makeText(getBaseContext(), "Motion detected", 
             // Toast.LENGTH_SHORT).show();
    	Cursor cursor=handler.getAllContact();
    	int it=1;
    	if(cursor.getCount()<1)
    	{
    		Toast.makeText(getApplicationContext(), "No sms body is set!", Toast.LENGTH_LONG).show();
    	}
    	else
    	{
    	
    		cursor.moveToFirst();
    		do
    		{   
    			if(it==cursor.getCount())
    			message=cursor.getString(cursor.getColumnIndex(handler.CONTACT_NAME));
    		//	Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();
    		   // cursor.close();
    			it++;
    		
    		    
    		}
    		while(cursor.moveToNext());
    	}
    	
       
       dataBase = mHelper.getWritableDatabase();
		Cursor mCursor = dataBase.rawQuery("SELECT * FROM "
				+ DbHelper.TABLE_NAME, null);

		//userId.clear();
		//user_fName.clear();
		//user_lName.clear();
		if(mCursor.getCount()<1)
		{
			Toast.makeText(getApplicationContext(), "No contacts available!Set contacts,sms body then Shake to send sms",
					Toast.LENGTH_LONG).show();
			
		}
		
		else if (mCursor.moveToFirst()) {
			do {
				
				//String message="i m in trouble,help me :( ";
			 phn=mCursor.getString(mCursor.getColumnIndex(DbHelper.KEY_LNAME));
			 SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(phn, null,message, null, null);
				Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();

			} while (mCursor.moveToNext());
			//Toast.makeText(getApplicationContext(),phn,Toast.LENGTH_LONG).show();
		}
		//DisplayAdapter disadpt = new DisplayAdapter(DisplayActivity.this,userId, user_fName, user_lName);
	
		mCursor.close();
	}


    
    @Override
    public void onResume() {
    	super.onResume();
       Toast.makeText(getBaseContext(), "After saving contacts,sms body always back to this screen and shake to send sms", 
               Toast.LENGTH_SHORT).show();
         
        //Check device supported Accelerometer senssor or not
        if (AccelerometerManager.isSupported(this)) {
             
            //Start Accelerometer Listening
            AccelerometerManager.startListening(this);
        }
    }
    
    
    @Override
    public void onStop() {
            super.onStop();
             
            //Check device supported Accelerometer senssor or not
            if (AccelerometerManager.isListening()) {
                 
                //Start Accelerometer Listening
                AccelerometerManager.stopListening();
                 
               //Toast.makeText(getBaseContext(), "onStop Accelerometer Stoped", 
                        //Toast.LENGTH_SHORT).show();
            }
            
    }
	
	     
}