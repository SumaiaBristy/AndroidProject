package com.example.clinicalguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminActivity extends Activity{
	EditText edt1,edt2,edt3,edt4;
	String txt1,txt2;
	Button add,del,dis;
	DataHandler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_activity);
	    edt1=(EditText)findViewById(R.id.editText1);
	    edt2=(EditText)findViewById(R.id.editText2);
	    edt3=(EditText)findViewById(R.id.editText3);
	    add=(Button)findViewById(R.id.button1);
	    del=(Button)findViewById(R.id.button2);
	    dis=(Button)findViewById(R.id.button3);
	    handler=new DataHandler(this);
	    add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 //Log.d("Insert: ", "Inserting ..");
				txt1=edt1.getText().toString();
				handler.addContact(txt1);
				Toast.makeText(getApplicationContext(), txt1, Toast.LENGTH_LONG).show();
			}
		});
	   
	  
      /*del.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  txt1=edt2.getText().toString();
				 final int id=Integer.valueOf(txt1);
				  
				 Toast.makeText(getApplicationContext(),id+" deleted",Toast.LENGTH_LONG).show();
				 handler.deleteContact(id);
				
			}
		});*/
		
	   
	   
	}
}
