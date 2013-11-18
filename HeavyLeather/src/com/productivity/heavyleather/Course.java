package com.productivity.heavyleather;

public class Course {

	String m_strName;
	
	public Course() {
		this.m_strName = "";
	}
	
	public Course(String name) {
		this.m_strName = name;
	}
	
	public String getName() {
		return this.m_strName;
	}
	
	public void setName(String name) {
		this.m_strName = name;
	}
}
