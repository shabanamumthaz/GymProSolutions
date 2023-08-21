package com.candella.dao;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Registration;
import com.candella.entity.Trainer;
import com.candella.service.TrainerServiceImpl;

public interface RegistrationDAO {
	
   
	
	public Registration getRegistration(int registrationId);
	
	public void updateRegistration(int registrationId, String columnName, String newValue);
	
	public List<Registration> displayAllRegistration();

	void addNewRegistration(Registration registration);
	

}
