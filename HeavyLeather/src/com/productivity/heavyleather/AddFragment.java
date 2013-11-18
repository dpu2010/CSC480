package com.productivity.heavyleather;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class AddFragment extends Fragment {
	
	private ArrayList<Course> courseList = new ArrayList<Course>();
	
	protected ListView m_vwCourseListView;
	protected View m_vw;
	protected CourseListAdapter m_courseAdapter;
	protected Button m_vwAddCourse;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.m_vw = inflater.inflate(R.layout.fragment_add, container, false);
		
		this.m_vwCourseListView = (ListView)this.m_vw.findViewById(R.id.course_list);
		this.m_courseAdapter = new CourseListAdapter(this.m_vw.getContext(), this.courseList);
		this.m_vwCourseListView.setAdapter(this.m_courseAdapter);
		this.m_vwAddCourse = (Button)this.m_vw.findViewById(R.id.add_course_button);
		
		populateCourseList();
		setupListView();
		
		return this.m_vw;
	}
	
private void populateCourseList() {
		
		for (int i = 0; i < 3; i++) {
			// For now just populate with dummy ingredients
			switch(i) {
				case 0:
					this.courseList.add(new Course("CPE 480 - Artificial Intelligence"));
					break;
				case 1:
					this.courseList.add(new Course("CPE 436 - Mobile Development"));
					break;
				case 2:
					this.courseList.add(new Course("CPE 468 - DBMS Implementation"));
					break;
				default:
					break;
			}
			this.m_courseAdapter.notifyDataSetChanged();
		}
	}
	
	private void setupListView() {
		this.m_vwCourseListView = (ListView) this.m_vw.findViewById(R.id.course_list);
		
	}
}
