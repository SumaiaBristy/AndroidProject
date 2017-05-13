package com.example.clinicalguide;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText input;
	Button bt1,bt2;
  String time="2000";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new AsynctaskRunner().execute();
		
	}
	
	public class AsynctaskRunner extends AsyncTask<String,String,String>
	{
		ProgressDialog dialog=new ProgressDialog(MainActivity.this);
       
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			dialog.setTitle("Loading!!wait for 2 seconds");
			dialog.setCancelable(false);
			dialog.show();
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			try {
				Thread.sleep(Integer.valueOf(time));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			//dialog.dismiss();
			Intent intent=new Intent(MainActivity.this,SampleWheelActivity.class);
			startActivity(intent);
			finish();
			//Toast.makeText(getApplicationContext(),"task completed",Toast.LENGTH_LONG).show();
		}
		
		
	}

}
