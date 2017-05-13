package com.example.clinicalguide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.app.Dialog;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity{
	GoogleMap map;
	Button direction,dis;
	LatLng loc,myloc;//marker bosar jonno j location object dorkar..location e double type er latitude and longitude kisu value thakbe
	Marker marker,myMarker;//ekta location er upor marker show krbo
	double lat,myLat,lon,myLon;
	LocationClient locationClient;//location access korar jnno j class er sthe conncet krte hbe
	String title,sni;
	
	boolean draw=false;//ekbar line draw krar por true hoye jabe
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_layout);
		direction=(Button)findViewById(R.id.button2);
		dis=(Button)findViewById(R.id.button1);
		
		
		 String uri=getIntent().getExtras().getString("item_name");
		   
		 if(uri.equals("031619597"))
		  {
			 
			 lat =  22.35967;
			  lon = 91.83318;
			  title="Chiitagong medical college and hospital";
			   sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031611407"))
		  {
			 lat =  22.34210;
			  lon = 91.83667;
			  title="Chittagong General Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031711236"))
		  {
			 lat =  22.32269;
			  lon = 91.80619;
			  title="Chittagong Maa-O-Shishu Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031620634"))
		  {
			 lat =  22.35899;
			  lon = 91.82489;
			  title="Chittagram Metropolitan Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-617495"))
		  {
			 lat =  22.3612559;
			  lon = 91.80240690000005;
			  title="Chittagong Diabetic general Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-651242"))
		  {
			 lat =  22.35899;
			  lon = 91.82489;
			  title="Chittagong Metropoliton Hospital (Pvt)";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031619378"))
		  {
			 lat =  24.724309500000000000;
			  lon = 46.846582899999930000;
			  title="Al-Zahar Hospital Ltd.";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-659070"))
		  {
			 lat =  22.36092;
			  lon = 91.79756;
			  title="B.B.M.H";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031639025"))
		  {
			 lat =  22.3437802;
			  lon = 91.83419040000001;
			  title="Centre Point Hospital (Pvt)Ltd";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-650911"))
		  {
			 lat =  22.36219;
			  lon = 91.83427;
			  title="Chittagong Poly Chinic";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031681551"))
		  {
			 lat =  22.41313;
			  lon = 91.80746;
			  title="Combined Military Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-651591"))
		  {
			 lat =  22.35967;
			  lon = 91.83318;
			  title="Desh Medical Services";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-715166"))
		  {
			 lat = 22.318119;
			  lon = 91.7782267;
			  title="Halishahar General Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031620025"))
		  {
			 lat =  22.3612559;
			  lon = 91.80240690000005;
			  title="Holy Crescent Hospital (Pvt.) Ltd";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-615710"))
		  {
			 lat =  22.3603158;
			  lon = 91.79630759999998;
			  title="Institute Of Community Opthalmology";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031616652"))
		  {
			 lat =  22.35899;
			  lon = 91.82489;
			  title="Lions Eye Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("622443"))
		  {
			 lat =  22.3612559;
			  lon = 91.80240690000005;
			  title="Lions General Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-651558"))
		  {
			 lat = 22.35967;
			  lon = 91.83318;
			  title="Ma Moni Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-616905"))
		  {
			 lat =  22.3475008;
			  lon = 91.81920289999994;
			  title="Medicare Services Ltd";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-623262"))
		  {
			 lat =  22.3513782;
			  lon = 91.82976009999993;
			  title="Mouni Hospital & Diagnostic Centre";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-623713"))
		  {
			 lat =  22.3597552;
			  lon = 91.82596209999997;
			  title="National Hospital Chittagong";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-613874"))
		  {
			 lat =  22.34210;
			  lon = 91.83667;
			  title="Panorama Hospital (Pvt) Ltd";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-654230"))
		  {
			 lat =  22.3614492;
			  lon = 91.833662;
			  title="Upasham Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("652728"))
		  {
			 lat =   22.35899 ;
			  lon =91.82489;
			  title="Chittagong Health Care Hospital Pvt. Ltd.";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031653036"))
		  {
			 lat = 22.3614492;
			  lon = 91.833662;
			  title="Niramoy Clinic Pvt. Ltd";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-658950"))
		  {
			 lat =  22.3614492;
			  lon =91.83427;
			  title="Pachlaish Maa-O-Shishu Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-658842"))
		  {
			 lat =  22.35899;
			  lon = 91.82489;
			  title="Royal Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-657629"))
		  {
			 lat =  22.3661522;
			  lon = 91.83348869999998;
			  title="Ekhushe Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-2550625"))
		  {
			 lat =  22.36667;
			  lon = 91.80000;
			  title="C.S.C.R";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-652635"))
		  {
			 lat =  22.3614492;
			  lon = 91.83427;
			  title="Sheba Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-655109"))
		  {
			 lat =  22.3394381;
			  lon = 91.78179139999997;
			  title="General Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("0341-64066"))
		  {
			 lat =  21.4422739;
			  lon = 91.97571249999999;
			  title="Cox'sbazar Sadar Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("031-654230"))
		  {
			 lat = 21.4422739;
			  lon = 91.97571249999999;
			  title="Cox'sbazar Seaside Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("0341-64674"))
		  {
			 lat = 21.263064;
			  lon = 91.583324;
			  title="Cox'sbazar Fuad Alkhatib Hospital";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("01819636433"))
		  {
			 lat = 22.085108;
			  lon = 92.05428239999992;
			  title="Shatkania Thana Health Complex";
			  sni="Zoom to get the location";
		  
		  }
		 else if(uri.equals("342256049"))
		  {
			 lat = 21.7621702;
			  lon = 92.07463499999994;
			  title="Cakaria Thana Health Complex";
			  sni="Zoom to get the location";
		  
		  }
		 
		
		if(!isMapAvailable())
		{
			Toast.makeText(getApplicationContext(),"sorry google play service is nt installed",Toast.LENGTH_LONG).show();
			finish();
		}
		else
		{
			
           
        
		  map=((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		  map.setMyLocationEnabled(true);
		  LatLng loc = new LatLng(lat, lon);

		  Marker marker = map.addMarker(new MarkerOptions().position(loc).title(title).snippet(sni));
            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        	
            map.moveCamera(CameraUpdateFactory.
            	newLatLngZoom(loc, 11.0f));
            marker.showInfoWindow();
		

			 
			
		}

		}

	public boolean isMapAvailable()
	{
		int result=GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		if(result==ConnectionResult.SUCCESS)
		{
			return true;
		}
		else if(GooglePlayServicesUtil.isUserRecoverableError(result))
		{
			Dialog d=GooglePlayServicesUtil.getErrorDialog(result, this,1);
			d.show();
			
			
		}
		else
		{
			Toast.makeText(getApplicationContext(),"Google play service nt supported",Toast.LENGTH_LONG).show();
			finish();
		}
		return false;

	    }




}