package com.example.clinicalguide;

import android.app.Dialog;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class DistanceActivity extends FragmentActivity implements GooglePlayServicesClient.ConnectionCallbacks,GooglePlayServicesClient.OnConnectionFailedListener,LocationListener
{
	GoogleMap map;
	 LocationClient locationClient;
	 Double myLat,myLon,lat,lon;
	 LatLng myLoc,loc2,loc;
		String title,sni;
protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.distance_layout);
		
		String uri=getIntent().getExtras().getString("item_name");
		   
		 if(uri.equals("031619597"))
		  {
			 
			 lat =  22.35967;
			  lon = 91.83318;
			  title="Chiitagong medical college and hospital";
			   sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031611407"))
		  {
			 lat =  22.34210;
			  lon = 91.83667;
			  title="Chittagong General Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031711236"))
		  {
			 lat =  22.32269;
			  lon = 91.80619;
			  title="Chittagong Maa-O-Shishu Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031620634"))
		  {
			 lat =  22.35899;
			  lon = 91.82489;
			  title="Chittagram Metropolitan Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-617495"))
		  {
			 lat =  22.3612559;
			  lon = 91.80240690000005;
			  title="Chittagong Diabetic general Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031619378"))
		  {
			 lat =  22.342162100000000000;
			  lon =91.828700600000050000;
			  title="Al-Zahar Hospital Ltd.";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-659070"))
		  {
			 lat =  22.36092;
			  lon = 91.79756;
			  title="B.B.M.H";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031639025"))
		  {
			 lat =  22.3437802;
			  lon = 91.8341904;
			  title="Centre Point Hospital (Pvt)Ltd";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-650911"))
		  {
			 lat =  22.36219;
			  lon = 91.83427;
			  title="Chittagong Poly Chinic";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031681551"))
		  {
			 lat =  22.41313;
			  lon = 91.80746;
			  title="Combined Military Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-651591"))
		  {
			 lat =  22.35967;
			  lon = 91.83318;
			  title="Desh Medical Services";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-715166"))
		  {
			 lat = 22.318119;
			  lon = 91.7782267;
			  title="Halishahar General Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031620025"))
		  {
			 lat =  22.3612559;
			  lon = 91.8024069;
			  title="Holy Crescent Hospital (Pvt.) Ltd";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-615710"))
		  {
			 lat =  22.3603158;
			  lon = 91.79630760;
			  title="Institute Of Community Opthalmology";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031616652"))
		  {
			 lat =  22.35899;
			  lon = 91.82489;
			  title="Lions Eye Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("622443"))
		  {
			 lat =  22.3612559;
			  lon = 91.80240695;
			  title="Lions General Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-651558"))
		  {
			 lat = 22.35967;
			  lon = 91.83318;
			  title="Ma Moni Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-616905"))
		  {
			 lat =  22.3475008;
			  lon = 91.81920290;
			  title="Medicare Services Ltd";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-623262"))
		  {
			 lat =  22.3513782;
			  lon = 91.829761;
			  title="Mouni Hospital & Diagnostic Centre";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-623713"))
		  {
			 lat =  22.3597552;
			  lon = 91.8259621;
			  title="National Hospital Chittagong";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-613874"))
		  {
			 lat =  22.34210;
			  lon = 91.83667;
			  title="Panorama Hospital (Pvt) Ltd";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-654230"))
		  {
			 lat =  22.3614492;
			  lon = 91.833662;
			  title="Upasham Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("652728"))
		  {
			 lat =   22.35899 ;
			  lon =91.82489;
			  title="Chittagong Health Care Hospital Pvt. Ltd.";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031653036"))
		  {
			 lat = 22.3614492;
			  lon = 91.833662;
			  title="Niramoy Clinic Pvt. Ltd";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-658950"))
		  {
			 lat =  22.3614492;
			  lon =91.83427;
			  title="Pachlaish Maa-O-Shishu Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-658842"))
		  {
			 lat =  22.35899;
			  lon = 91.82489;
			  title="Royal Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-657629"))
		  {
			 lat =  22.3661522;
			  lon = 91.83348870;
			  title="Ekhushe Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-2550625"))
		  {
			 lat =  22.36667;
			  lon = 91.80000;
			  title="C.S.C.R";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-652635"))
		  {
			 lat =  22.3614492;
			  lon = 91.83427;
			  title="Sheba Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-655109"))
		  {
			 lat =  22.3394381;
			  lon = 91.7817914;
			  title="General Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("0341-64066"))
		  {
			 lat =  21.4422739;
			  lon = 91.97571250;
			  title="Cox'sbazar Sadar Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("031-654230"))
		  {
			 lat = 21.4422739;
			  lon = 91.9757125;
			  title="Cox'sbazar Seaside Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("0341-64674"))
		  {
			 lat = 21.263064;
			  lon = 91.583324;
			  title="Cox'sbazar Fuad Alkhatib Hospital";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("01819636433"))
		  {
			 lat = 22.085108;
			  lon = 92.0542824;
			  title="Shatkania Thana Health Complex";
			  sni="Click to show distance";
		  
		  }
		 else if(uri.equals("342256049"))
		  {
			 lat = 21.7621702;
			  lon = 92.074635;
			  title="Cakaria Thana Health Complex";
			  sni="Click to show distance";
		  
		  }
		 
		  
		
        if ( isMapAvailable() ) 
        {
               map =  ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
              // map.setMyLocationEnabled(true);
               if(map!=null)
               {
            	   map.setMyLocationEnabled(true);
         		   
            	   
            	   
            	   
                   try{
                       locationClient = new LocationClient(this, this,this);  
                       locationClient.connect();           
                  }
                  catch (Exception e) {
                      Toast.makeText(getApplicationContext(), e+"", Toast.LENGTH_LONG).show();
                                       }            

            	   
               }
         }
       else  
        {
                 Toast.makeText(getApplicationContext(), "Map is not available in your device",Toast.LENGTH_LONG).show();
                 finish();
         }

	
}

public boolean isMapAvailable() {
int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
if (ConnectionResult.SUCCESS == resultCode) {
return true;
} else if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
// Service Missing or Service needs update or Service disabled
 Dialog d = GooglePlayServicesUtil.getErrorDialog(resultCode, this,1);
d.show();
} else {
Toast.makeText(getApplicationContext(), "Google Maps API V2 is not supported in your device!",Toast.LENGTH_LONG).show();
finish();   }
return false;  }


@Override
public void onConnected(Bundle arg0) {
	Location currentLocation = locationClient.getLastLocation();
	try{
	       myLat = currentLocation.getLatitude();
	       myLon = currentLocation.getLongitude();
	        myLoc = new LatLng(myLat , myLon);
		            Marker myMarker =map.addMarker(new MarkerOptions().position(myLoc).title("You are here!").snippet("Click here to show distance"));                                 
	                 myMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
	                 map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLoc, 11.0f)); 
                     myMarker.showInfoWindow();
                     
                    
               	   
                     
                     
                     map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
                    	 @Override
                    	 public void onInfoWindowClick(Marker marker) {
                    	 // TODO Auto-generated method stub
                    	     // String title=marker.getTitle();
                    	     // Toast.makeText(getApplicationContext(), “Info window with title  “+title + “   is clickrd”,  Toast.LENGTH_LONG).show();
                    	      
                    		 loc = new LatLng(lat, lon);

                   		  Marker marker1 = map.addMarker(new MarkerOptions().position(loc).title(title).snippet(sni));
                               marker1.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
                           	
                               map.moveCamera(CameraUpdateFactory.
                               	newLatLngZoom(loc, 11.0f));
                               marker1.showInfoWindow();
                      	   
                    		 
                    		 
                    	      float[] results = new float[1]; 
                    	     // double lat1 = 22.368025;
                    	     // double lon1 = 91.849106;
                    	      //double lat2 = 22.351451;
                    	      //double lon2 =  91.852068;
                    	      //loc2 = new LatLng(lat2,lon2);
                    	      Location.distanceBetween(myLat,myLon,lat,lon, results);
                    	      float distance=results[0]/1000;
                    	      PolylineOptions line= new PolylineOptions().add(myLoc,loc).width(5).color(Color.BLUE);
                    	      map.addPolyline(line); 

              				Toast.makeText(getApplicationContext(), "Distance is: "+distance+" km", Toast.LENGTH_LONG).show();
                    	 
                    	 
                    	 
                    	 
                    	 }
                    	 });


	 }
	catch(Exception e)
	{
	Toast.makeText(getApplicationContext(), "Your present location not found, try again.",Toast.LENGTH_LONG).show();
	finish();
	}     

}

@Override
public void onDisconnected() {
	// TODO Auto-generated method stub
	
}

@Override
public void onConnectionFailed(ConnectionResult arg0) {
	// TODO Auto-generated method stub
	
	
	
	
	
}

@Override
public void onLocationChanged(Location location) {
	// TODO Auto-generated method stub
	
}

@Override
public void onProviderDisabled(String provider) {
	// TODO Auto-generated method stub
	
}

@Override
public void onProviderEnabled(String provider) {
	// TODO Auto-generated method stub
	
}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
	// TODO Auto-generated method stub
	
}

}