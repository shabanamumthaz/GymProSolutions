package com.candella.entity;

public class Trainer {
	
	private int trainerId;
	private String trainerName;
	private String emailId;
	private long phoneNumber;
	private String Specialization;
	public Trainer(int trainerId, String trainerName, String emailId, long phoneNumber, String specialization) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		Specialization = specialization;
	}
	public Trainer() {
		// TODO Auto-generated constructor stub
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	
	
	
}
