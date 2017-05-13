package com.example.clinicalguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

public class User extends Activity  {
	WebView web1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        web1=(WebView)findViewById(R.id.webView1);
       //  String selectedItem=getIntent().getExtras().getString("item_name");
        
        web1.getSettings().setJavaScriptEnabled(true);
        
        web1.getSettings().setBuiltInZoomControls(true);
        
			 //web1.loadUrl("http://www.donatebloodbd.com/donor-list.html?start=30");
			  web1.loadUrl("file:///android_asset/webpage/userguide.html");
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
