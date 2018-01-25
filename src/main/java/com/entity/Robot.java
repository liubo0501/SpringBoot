package com.entity;

import java.util.List;
import java.util.Map;

public class Robot {
	private String robotId;
	private String robotName;
	private String area;
	private List<Map<String,Object>> userGroups;
	public String getRobotId() {
		return robotId;
	}
	public void setRobotId(String robotId) {
		this.robotId = robotId;
	}
	public String getRobotName() {
		return robotName;
	}
	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public List<Map<String, Object>> getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(List<Map<String, Object>> userGroups) {
		this.userGroups = userGroups;
	}

}
