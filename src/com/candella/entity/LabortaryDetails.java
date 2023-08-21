package com.candella.entity;

public class LabortaryDetails {
	private int LabId;
	private String name;
	private String Location;
	
	public LabortaryDetails(int labId, String name, String location) {
		super();
		LabId = labId;
		this.name = name;
		Location = location;
	}
	public LabortaryDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public int getLabId() {
		return LabId;
	}
	public void setLabId(int labId) {
		LabId = labId;
	}
	
	

}
