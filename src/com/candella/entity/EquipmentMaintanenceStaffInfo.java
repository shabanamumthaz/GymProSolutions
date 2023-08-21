package com.candella.entity;

public class EquipmentMaintanenceStaffInfo {
	
	private int staffId;
	private String staffName;
	private int phoneNumber;
	private String Location;
	public EquipmentMaintanenceStaffInfo(int staffId, String staffName, int phoneNumber, String location) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.phoneNumber = phoneNumber;
		Location = location;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	

}
