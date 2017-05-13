package com.example.clinicalguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

public class TipWebActivity extends Activity  {
	WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tipweb_activity);
        web1=(WebView)findViewById(R.id.webView1);
         String selectedItem=getIntent().getExtras().getString("item_name");
        
        web1.getSettings().setJavaScriptEnabled(true);
        
        web1.getSettings().setBuiltInZoomControls(true);
        if(selectedItem.equals("Donate blood"))
		 {
			 web1.loadUrl("http://www.donatebloodbd.com/donor-list.html?start=30");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("Blood bank"))
		 {
			 web1.loadUrl("http://www.bloodbank.com.bd/index.php?module=home");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("Doctorsbd.com"))
		 {
			 web1.loadUrl("http://www.doctorsbd.com/");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("Red Drop online blood bank"))
		 {
			 web1.loadUrl("http://reddrop.org/index.php?showPage=donoract");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("Chittagong medical services"))
		 {
			 web1.loadUrl("http://chittagong-district.infoisinfo.com.bd/search/medical-services");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("Robi emergency helpline"))
		 {
			 web1.loadUrl("https://www.robi.com.bd/en/vas/information-services/emergency-helpline");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("GP emergency helpline"))
		 {
			 web1.loadUrl("http://www.healthdirect.gov.au/after-hours-gp-helpline");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("Banglalink emergency helpline"))
		 {
			 web1.loadUrl("http://peperonity.com/sites/solution.blinfo/23679667");
			 // web1.loadUrl("file:///android_asset/webpage/heart.html");
			 
		 }
        if(selectedItem.equals("Airtel emergency helpline"))
		 {
			 web1.loadUrl("http://www.medianama.com/2011/08/223-airtel-mediphone-religare/");
				 
		 }
        if(selectedItem.equals("Emergency Blood,Hospital,Ambulance helpline"))
		 {
			 web1.loadUrl("http://free4m.wen9.com/HELPLINE.html");
		
			 
		 }
        if(selectedItem.equals("First Aid and emergency treatments"))
		 {
			 web1.loadUrl("http://www.webmd.com/first-aid/first-aid-treatment");
		
			 
		 }
        if(selectedItem.equals("Blood bank in different division"))
		 {
			 web1.loadUrl("http://itlinkbd.com/health/blood-bank.html");
		
			 
		 }
          
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
