package com.example.clinicalguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondFragment extends Fragment{
	Button btn;
	Context context;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View view=inflater.inflate(R.layout.second_layout,container,false);//layout jeta inflate krtsi ta parent er sthe eksthe return krbe jdi tru dei..ar false deyate sudhu amdr layout tai return hbe
	btn=(Button)view.findViewById(R.id.button1);     
	context=view.getContext();
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(context,"Button on second fragment is clicked",Toast.LENGTH_LONG).show();
			
		}
	});
	
	
	return view;
            }

}
