package com.codeMantra.model;

import java.util.Date;

public class User {
	private Date date;
	private String starttime;
	private String endtime;
	private String projectname;
	private String taskname;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStartTime() {
		return starttime;
	}
	public void setStartTime(String startTime) {
		this.starttime = startTime;
	}
	public String getEndTime() {
		return endtime;
	}
	public void setEndTime(String endTime) {
		this.endtime = endTime;
	}
	public String getProjectName() {
		return projectname;
	}
	public void setProjectName(String projectName) {
		this.projectname = projectName;
	}
	public String getTaskName() {
		return taskname;
	}
	public void setTaskName(String taskName) {
		this.taskname = taskName;
	}
}
