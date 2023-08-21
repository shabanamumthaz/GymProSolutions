package com.candella.entity;

import java.time.LocalDate;

public class GymMember {
	private int memberId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String gender;
	private String emailId;
	private String phoneNumber;
	private String Address;
	private String emergencyContactName;
	private String emergencyContactPhoneNo;
	
	public GymMember(int memberId, String firstName, String lastName, LocalDate memberDoB, String gender,
			String emailId, String phoneNumber, String address,
			String emergencyContactName, String emergencyContactPhoneNo) {
		super();
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = memberDoB;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		Address = address;
		this.emergencyContactName = emergencyContactName;
		this.emergencyContactPhoneNo = emergencyContactPhoneNo;
	}
	public GymMember() {
		// TODO Auto-generated constructor stub
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}
	public String getEmergencyContactPhoneNo() {
		return emergencyContactPhoneNo;
	}
	public void setEmergencyContactPhoneNo(String emergencyContactPhoneNo) {
		this.emergencyContactPhoneNo = emergencyContactPhoneNo;
	}
	
	
	
	
	
	

}
