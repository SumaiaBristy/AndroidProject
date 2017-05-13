package com.example.clinicalguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends Activity{
	
	EditText edt1;
	String txt1;
	Button add,save,name;
	DataHandler handler;
	   protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
    setContentView(R.layout.sms);
    save=(Button)findViewById(R.id.button1);
    edt1=(EditText)findViewById(R.id.frst_editTxt);
    
	handler=new DataHandler(this);
    save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			txt1=edt1.getText().toString();
			handler.addContact(txt1);
			//Toast.makeText(getApplicationContext(),txt1+"\n",Toast.LENGTH_LONG).show();
			
		}
	});
	   }

}
