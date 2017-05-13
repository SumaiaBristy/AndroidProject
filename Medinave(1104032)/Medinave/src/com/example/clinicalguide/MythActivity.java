package com.example.clinicalguide;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MythActivity extends Activity{
	WebView web1;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myth_activity);
		web1=(WebView)findViewById(R.id.webView1);
		 web1.loadUrl("http://www.uamshealth.com/medicalmyths");
	}

}
