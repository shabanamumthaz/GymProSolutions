package com.candella.service;

import java.util.List;

import com.candella.entity.Registration;

public interface RegistrationService {
	
	 public void addNewRegistration(Registration registration);
		
		public Registration getRegistration(int registrationId);
		
		public void updateRegistration(int registrationId, String columnName, String newValue);
		
		public List<Registration> displayAllRegistration();

}
