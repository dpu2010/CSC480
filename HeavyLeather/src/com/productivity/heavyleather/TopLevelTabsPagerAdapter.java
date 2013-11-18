package com.productivity.heavyleather;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class TopLevelTabsPagerAdapter extends FragmentPagerAdapter {
	private static final int FRAG_CNT = 3;
	private List<Fragment> fragments = new ArrayList<Fragment>();
	private FragmentManager fm;
	

	public TopLevelTabsPagerAdapter(FragmentManager fm) {
		super(fm);

		this.fm = fm;
		
		fragments.add(new HomeFragment());
		fragments.add(new AddFragment());
		fragments.add(new CalendarFragment());
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return FRAG_CNT;
	}
	
	public Fragment getActiveFragment(ViewPager container, int position) {
		String name = "android:switcher:" + container.getId() + ":" + position;
		return fm.findFragmentByTag(name);
	}

}
