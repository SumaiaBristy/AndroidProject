package com.example.clinicalguide;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class vaccinActivity extends Activity {
	
	Button dis,vac;
	ListView list;
	TextView text;
	ArrayList<String> data;
	ArrayAdapter<String>adapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vaccin_activity);
		 list=(ListView)findViewById(R.id.listView1);
		 dis=(Button)findViewById(R.id.button1);
       data=new ArrayList<String>();
       data.add("Rubella                     MMR Vaccine");
       data.add("Rabies                    Rabies Vaccine");
       data.add("Poliomyelitis             Polio vaccine");
       data.add("Chickenpox           Varicella vaccine");
       data.add("Smallpox             Smallpox vaccine");
       data.add("Cervical cancer          HPV Vaccine");
       data.add("Hepatitis A              HepatitisA");
       data.add("Hepatitis B              HepatitisB");
       data.add("Hepatitis E              HepatitisE");
       adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
       list.setAdapter(adapter);
   }
	
	

}
