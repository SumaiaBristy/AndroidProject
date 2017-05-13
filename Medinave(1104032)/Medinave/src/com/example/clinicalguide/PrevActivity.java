package com.example.clinicalguide;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class PrevActivity extends ActionBarActivity implements ActionBar.TabListener{

	MyPagerAdapter adapter;
	ViewPager pager;
	ActionBar actionBar;
	String[] tabs={"Symptoms","Prevention"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prev_activity);
		adapter=new MyPagerAdapter(getSupportFragmentManager());
		pager=(ViewPager)findViewById(R.id.pager);
		pager.setAdapter(adapter);
		actionBar=getSupportActionBar();
		for(int i=0;i<tabs.length;i++)
		{
			actionBar.addTab(actionBar.newTab().setText(tabs[i]).setTabListener(this));
			
		}
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); //tab chnge er sthe sthe navigatn bar tao chnge hbe
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				actionBar.setSelectedNavigationItem(pos);//page chnge hle call hbe ja selected navigatn item er postn nibe
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		pager.setCurrentItem(tab.getPosition()); //tab select krle tar corresponding page ta show hbe
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

}
