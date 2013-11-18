package com.productivity.heavyleather;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TaskView extends RelativeLayout {

	private TextView m_vwTaskName;
	private TextView m_vwTaskStart;
	private TextView m_vwTaskEnd;
	
	private Task m_task;
	
	public TaskView(Context context) {
		super(context);
	}
	
	public TaskView(Context context, Task task) {
		super(context);
		
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.task_view, this, true);
		
		this.m_vwTaskName = (TextView)findViewById(R.id.task_name);
		this.m_vwTaskStart = (TextView)findViewById(R.id.task_start);
		this.m_vwTaskEnd = (TextView)findViewById(R.id.task_end);
		setTask(task);
	}
	
	public Task getTask() {
		return this.m_task;
	}
	
	public void setTask(Task task) {
		this.m_task = task;
		this.m_vwTaskName.setText(task.getName());
		this.m_vwTaskStart.setText(""+task.getStartTime());
		this.m_vwTaskEnd.setText(""+task.getEndTime());
	}
}
