package com.example.clinicalguide;

import org.apache.cordova.Config;
import org.apache.cordova.DroidGap;

import android.os.Bundle;

public class StepActivity extends DroidGap{
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	super.loadUrl(Config.getStartUrl());
	}

}
