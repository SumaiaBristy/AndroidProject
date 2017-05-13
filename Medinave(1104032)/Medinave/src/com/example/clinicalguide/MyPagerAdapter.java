package com.example.clinicalguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter{

	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int index) { //jtobar sliding krbo totbar ei method call hbe..index 0 hle frst fragment parameter
		// TODO Auto-generated method stub
		if(index==0) return new FirstFragment();
		else if(index==1) return new SecondFragment();
		return null;
	}

	@Override
	public int getCount() { //return krbe koita fragment
		// TODO Auto-generated method stub
		return 2; //2ta fragemnt return krbe
	}

}
