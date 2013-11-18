package com.productivity.heavyleather;

public class Task {

	String m_strName;
	int m_nStartTime, m_nEndTime;
	
	public Task() {
		this.m_strName = "";
		this.m_nStartTime = 0;
		this.m_nEndTime = 0;
	}
	
	public Task(String name) {
		this.m_strName = name;
		this.m_nStartTime = 0;
		this.m_nEndTime = 0;
	}
	
	public Task(String name, int start) {
		this.m_strName = name;
		this.m_nStartTime = start;
		this.m_nEndTime = 0;
	}
	
	public Task(String name, int start, int end) {
		this.m_strName = name;
		this.m_nStartTime = start;
		this.m_nEndTime = end;
	}
	
	public String getName() {
		return this.m_strName;
	}
	
	public void setName(String name) {
		this.m_strName = name;
	}
	
	public int getStartTime() {
		return this.m_nStartTime;
	}
	
	public void setStartTime(int time) {
		this.m_nStartTime = time;
	}
	
	public int getEndTime() {
		return this.m_nEndTime;
	}
	
	public void setEndTime(int time) {
		this.m_nEndTime = time;
	}
}
