package com.productivity.heavyleather;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class TopLevelTabs extends FragmentActivity {
	
	TopLevelTabsPagerAdapter myPagerAdapter;
	ViewPager mViewPager;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_activity_top_level_tabs);
		
		int position = 0;
		
		setupPager();
		setupActionBar(position);
	}
	
	private void setupPager() {
		// ViewPager and its adapter use support library fragments
		// So use getSupportFragmentManager
		myPagerAdapter = new TopLevelTabsPagerAdapter(getSupportFragmentManager());
		
		mViewPager = (ViewPager)findViewById(R.id.pager);
		mViewPager.setAdapter(myPagerAdapter);
		
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int pos) {
				getActionBar().setSelectedNavigationItem(pos);
			}
		});
	}
	
	private void setupActionBar(int position) {
		// Obtain ActionBar
		final ActionBar aBar = getActionBar();
		
		// Set ActionBar to Tab Mode
		aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		// Add Tab Listeners to handle changing the fragment
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				mViewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				// Do nothing
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// Do nothing
			}
		};
		
		// Add tabs and register the event handlers for tabs
		aBar.addTab(aBar.newTab().setText("Home").setTabListener(tabListener));
		aBar.addTab(aBar.newTab().setText("Add").setTabListener(tabListener));
		aBar.addTab(aBar.newTab().setText("Calendar").setTabListener(tabListener));
		
		// Set the start position of the tab to the position passed into function
		aBar.setSelectedNavigationItem(position);
	}
}
