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
import com.google.android.gms.internal.df;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class NearestHos extends FragmentActivity implements GooglePlayServicesClient.ConnectionCallbacks,GooglePlayServicesClient.OnConnectionFailedListener,LocationListener
{
	GoogleMap map;
	 LocationClient locationClient;
	 int lat_p;
	 Double myLat,myLon,lat,lon,latf,lonf,distance,temp=(Double) 300.00;
	 LatLng myLoc,loc2,loc;
		String title,sni;
	Double[] a={22.35967,22.34210,22.32269,22.35899,22.3612559,22.35899,22.342162100000000000,22.36092,22.3437802,
			22.36219,22.41313,22.318119,22.3612559,22.3603158,22.3612559,22.3475008,22.3597552,
			22.3572474,22.3614492,22.3661522,22.36667,21.4422739,21.263064,22.085108,21.734966100000000000,22.3513782};
		
		
		Double[] b={91.83318,91.83667,91.80619,91.82489,91.802406900000005,91.82489,91.82870060000005,91.79756,91.83419040000001
				,91.83427,91.80746,91.7782267,91.8024069,91.79630759999998,91.8024069,91.81920289999994,91.82596209999997,
				91.83738960000005,91.833662,91.83348869999998,91.80000,91.97571249999999,91.583324,92.05428239999992
				,92.087359099999960000,91.82976009999993};
		
		
		String[] title1={"Chittagong Medical College & Hospital","Chittagong General Hospital","Chittagong Maa-O-Shishu Hospital",
				"Chittgong Metropolitan Hospital","Chittagong Diabetic general Hospital","Chittagong Metropoliton Hospital (Pvt)",
				"Al-Zahar Hospital Ltd.","B.B.M.H","Centre Point Hospital (Pvt)Ltd","Chittagong Poly Chinic ","Combined Military Hospital",
				"Halishahar General Hospital","Holy Crescent Hospital (Pvt.) Ltd","Institute Of Community Opthalmology",
				"Lions General Hospital","Medicare Services Ltd","National Hospital Chittagong","Panorama Hospital (Pvt) Ltd",
				"Upasham Hospital","Ekhushe Hospital","C.S.C.R ","Cox'sbazar Sadar Hospital","Cox'sbazar Fuad Alkhatib Hospital",
				"Shatkania Thana Health Complex","Cakaria Thana Health Complex","Mouni Hospital & Diagnostic Centre"
				};
protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nearest_hos);
		
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
		            Marker myMarker =map.addMarker(new MarkerOptions().position(myLoc).title("You are here!").snippet("Click here to show nearest hospital"));                                 
	                 myMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
	                 map.moveCamera(CameraUpdateFactory.newLatLngZoom(myLoc, 11.0f)); 
                     myMarker.showInfoWindow();
                     
                    
               	   
                     
                     
                     map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
                    	 @Override
                    	 public void onInfoWindowClick(Marker marker) {
                    	 // TODO Auto-generated method stub
                    	     // String title=marker.getTitle();
                    	     // Toast.makeText(getApplicationContext(), “Info window with title  “+title + “   is clickrd”,  Toast.LENGTH_LONG).show();
                    	      
                    		 for(int i=0;i<a.length;i++){
                    			 loc = new LatLng(a[i],b[i]);
                    			 
                    		 
                    		

                   		  Marker marker1 = map.addMarker(new MarkerOptions().position(loc).title(title1[i]).snippet(""));
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
                    	      lat=a[i];lon=b[i];
                    	      Location.distanceBetween(myLat,myLon,lat,lon, results);
                    	       distance=(double) (results[0]/1000);
                    	       if(distance<temp){
                    	    	   
                    	    	   latf=a[i];lonf=b[i];
                    	    	   lat_p=i;
                    	    	   temp=distance;
                    	       }
                    		 }
                    		 loc2 = new LatLng(latf,lonf);
                    	      PolylineOptions line= new PolylineOptions().add(myLoc,loc2).width(5).color(Color.RED);
                    	      Marker marker1 = map.addMarker(new MarkerOptions().position(loc2).title(title1[lat_p]).snippet("Click to see the distance"));
                              marker1.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                          	
                              map.moveCamera(CameraUpdateFactory.
                              	newLatLngZoom(loc2, 11.0f));
                              marker1.showInfoWindow();
                    	      map.addPolyline(line); 

              				Toast.makeText(getApplicationContext(), "Distance is: "+temp+" km", Toast.LENGTH_LONG).show();
                    	 
                    	 
                    	 
                    	 
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