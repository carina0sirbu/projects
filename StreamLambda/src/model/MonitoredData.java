package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MonitoredData {
	
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String activityLabel;
	
	public MonitoredData(String startTime, String endTime, String activityLabel) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		this.startTime = LocalDateTime.parse(startTime, formatter);
		this.endTime = LocalDateTime.parse(endTime, formatter);
		
		this.activityLabel = activityLabel;
	}
	
	
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public String getActivityLabel() {
		return activityLabel;
	}
	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}
	

}
