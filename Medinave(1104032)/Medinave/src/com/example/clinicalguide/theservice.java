package com.example.clinicalguide;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class theservice extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stubo
		//Toast.makeText(getApplicationContext(),"service created",Toast.LENGTH_LONG).show();
		super.onCreate();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		//Toast.makeText(getApplicationContext(),"service started",Toast.LENGTH_LONG).show();
		Intent i = new Intent();
        i.setClass(this, MainAccelerometer.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(i);
		return START_STICKY;
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		//Toast.makeText(getApplicationContext(),"service destroyed",Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

}
