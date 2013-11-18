package com.productivity.heavyleather;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CourseListAdapter extends BaseAdapter {

	private Context m_context;
	private List<Course> m_courseList;
	
	public CourseListAdapter(Context context, List<Course> courseList) {
		this.m_context = context;
		this.m_courseList = courseList;
	}
	
	@Override
	public int getCount() {
		return this.m_courseList.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.m_courseList.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CourseView courseView;
		
		if (convertView == null) {
			courseView = new CourseView(this.m_context, this.m_courseList.get(position));
		} else {
			courseView = (CourseView)convertView;
		}
		
		courseView.setCourse(this.m_courseList.get(position));
		return courseView;
	}
}
