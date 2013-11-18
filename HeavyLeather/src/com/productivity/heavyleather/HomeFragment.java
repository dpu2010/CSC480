package com.productivity.heavyleather;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeFragment extends Fragment {
	
	private ArrayList<Task> taskList = new ArrayList<Task>();
	
	protected ListView m_vwTaskListView;
	protected View m_vw;
	protected TaskListAdapter m_taskAdapter;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.m_vw = inflater.inflate(R.layout.fragment_home, container, false);
		
		setupListView();
		populateTaskList();
		
		return this.m_vw;
	}
	
	private void populateTaskList() {
		
		for (int i = 0; i < 3; i++) {
			// For now just populate with dummy ingredients
			switch(i) {
				case 0:
					this.taskList.add(new Task("Task 1", 3, 4));
					break;
				case 1:
					this.taskList.add(new Task("Task 2", 6, 8));
					break;
				case 2:
					this.taskList.add(new Task("Task 3", 8, 10));
					break;
				default:
					break;
			}
			this.m_taskAdapter.notifyDataSetChanged();
		}
	}
	
	private void setupListView() {
		this.m_vwTaskListView = (ListView)this.m_vw.findViewById(R.id.task_list);
		this.m_taskAdapter = new TaskListAdapter(this.m_vw.getContext(), this.taskList);
		this.m_vwTaskListView.setAdapter(this.m_taskAdapter);
	}
}
