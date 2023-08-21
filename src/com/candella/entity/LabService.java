package com.candella.entity;

import java.time.LocalDate;

public class LabService {
	
	private int labServiceId;
	private Registration registration;
	private LabortaryDetails labortaryDetails;
	private String serviceDescription;
	private String status;
	private LocalDate dateOfService;
	public LabService(int labServiceId, Registration registration, LabortaryDetails labortaryDetails,
			String serviceDescription, String status, LocalDate dateOfService) {
		super();
		this.labServiceId = labServiceId;
		this.registration = registration;
		this.labortaryDetails = labortaryDetails;
		this.serviceDescription = serviceDescription;
		this.status = status;
		this.dateOfService = dateOfService;
	}
	public LabService() {
		// TODO Auto-generated constructor stub
	}
	public int getLabServiceId() {
		return labServiceId;
	}
	public void setLabServiceId(int labServiceId) {
		this.labServiceId = labServiceId;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public LabortaryDetails getLabortaryDetails() {
		return labortaryDetails;
	}
	public void setLabortaryDetails(LabortaryDetails labortaryDetails) {
		this.labortaryDetails = labortaryDetails;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDateOfService() {
		return dateOfService;
	}
	public void setDateOfService(LocalDate dateOfService) {
		this.dateOfService = dateOfService;
	}
	
	
}
