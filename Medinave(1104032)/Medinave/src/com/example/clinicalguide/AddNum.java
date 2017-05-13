package com.example.clinicalguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNum extends Activity{
	EditText edt1,edt2;
	String txt1,txt2;
	Button add,save,name;
	DataHandler1 handler;
	   protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
    setContentView(R.layout.add_num);
    save=(Button)findViewById(R.id.button3);
    edt1=(EditText)findViewById(R.id.editText1);
    edt2=(EditText)findViewById(R.id.editText2);
	handler=new DataHandler1(this);
    save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			txt1=edt1.getText().toString();
			txt2=edt2.getText().toString();
			handler.addContact(txt1,txt2);
			Toast.makeText(getApplicationContext(),txt1+"\n"+txt2,Toast.LENGTH_LONG).show();
			
		}
	});
}

}
