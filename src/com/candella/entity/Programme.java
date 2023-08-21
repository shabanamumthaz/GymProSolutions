package com.candella.entity;

public class Programme {
	private int programmeId;
	private String programmeName;
	private String description;
	private double programmePrice;
	private String schedule;
	private int noOfDays;
	private int attendancePerWeek;
	
	public Programme(int programmeId, String programmeName, String description, double programmePrice, String schedule,
			int noOfDays, int attendancePerWeek) {
		super();
		this.programmeId = programmeId;
		this.programmeName = programmeName;
		this.description = description;
		this.programmePrice = programmePrice;
		this.schedule = schedule;
		this.noOfDays = noOfDays;
		this.attendancePerWeek = attendancePerWeek;
	
	}
	public Programme() {
		// TODO Auto-generated constructor stub
	}
	public int getProgrammeId() {
		return programmeId;
	}
	public void setProgrammeId(int programmeId) {
		this.programmeId = programmeId;
	}
	public String getProgrammeName() {
		return programmeName;
	}
	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getProgrammePrice() {
		return programmePrice;
	}
	public void setProgrammePrice(double programmePrice) {
		this.programmePrice = programmePrice;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public int getAttendancePerWeek() {
		return attendancePerWeek;
	}
	public void setAttendancePerWeek(int attendancePerWeek) {
		this.attendancePerWeek = attendancePerWeek;
	}
	
	
	

}
