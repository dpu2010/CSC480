package com.productivity.heavyleather;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CourseView extends RelativeLayout {

	private TextView m_vwCourseName;
	
	private Course m_course;
	
	public CourseView(Context context) {
		super(context);
	}
	
	public CourseView(Context context, Course course) {
		super(context);
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.course_view, this, true);
		
		this.m_vwCourseName = (TextView)findViewById(R.id.course_name);
		setCourse(course);
	}
	
	public Course getCourse() {
		return this.m_course;
	}
	
	public void setCourse(Course course) {
		this.m_course = course;
		this.m_vwCourseName.setText(course.getName());
	}
}
