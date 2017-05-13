package com.example.clinicalguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//2ta page er jnno 2ta fragment create krsi
//Fragement er jnno ekta oncreateview method call hoi
//fragment er khetre getapplicationcontext kaj kre na so getcontext();
public class FirstFragment extends Fragment{
	Context context;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View view=inflater.inflate(R.layout.first_layout,container,false);//layout jeta inflate krtsi ta parent er sthe eksthe return krbe jdi tru dei..ar false deyate sudhu amdr layout tai return hbe   
	context=view.getContext();
    
	/* if(selectedItem.equals("CUET"))
	 {
		 web1.loadUrl("http://www.cuet.ac.bd");
		 
	 }*/
	
	
	return view;
            }
}
