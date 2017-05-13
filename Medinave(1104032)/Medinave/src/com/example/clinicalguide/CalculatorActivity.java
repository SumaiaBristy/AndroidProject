package com.example.clinicalguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculatorActivity extends Activity{
	Button we,he,check;
	EditText edt1,edt2;
	String txt1,txt2;
	double weight,height;
	double ans,h1;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator_activity);
		edt1=(EditText)findViewById(R.id.editText1);
		edt2=(EditText)findViewById(R.id.editText2);
		check=(Button)findViewById(R.id.button3);
		check.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txt1=edt1.getText().toString();
				txt2=edt2.getText().toString();
				 weight = Double.parseDouble(txt1);
				height= Double.parseDouble(txt2);
				h1=(Double) (height*.0254);
				//Toast.makeText(getApplicationContext(),"height"+h1,Toast.LENGTH_LONG).show();
				ans=(Double)weight/(h1*h1);
				if(ans<16)
					Toast.makeText(getApplicationContext(),"Severely Under Weight",Toast.LENGTH_LONG).show();
				else if(ans<18.5)
					Toast.makeText(getApplicationContext(),"Under Weight",Toast.LENGTH_LONG).show();
				else if(ans>=18.5&&ans<=25)
					Toast.makeText(getApplicationContext(),"Perfect Weight",Toast.LENGTH_LONG).show();
				else
					Toast.makeText(getApplicationContext(),"Over Weight",Toast.LENGTH_LONG).show();
				
			}
		});
	}
}
