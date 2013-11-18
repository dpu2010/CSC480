package com.productivity.heavyleather;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TaskListAdapter extends BaseAdapter {

	private Context m_context;
	private List<Task> m_taskList;
	
	public TaskListAdapter(Context context, List<Task> taskList) {
		this.m_context = context;
		this.m_taskList = taskList;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.m_taskList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.m_taskList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TaskView taskView;
		
		if (convertView == null) {
			taskView = new TaskView(this.m_context, this.m_taskList.get(position));
		} else {
			taskView = (TaskView)convertView;
		}
		
		taskView.setTask(this.m_taskList.get(position));
		return taskView;
	}

}
