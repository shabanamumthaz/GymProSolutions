package com.candella.service;

import java.util.List;

import com.candella.dao.RegistrationDAOImpl;
import com.candella.entity.Registration;

public class RegistrationServiceImpl implements RegistrationService{
	RegistrationDAOImpl registrationDAOImpl=new RegistrationDAOImpl();

	@Override
	public void addNewRegistration(Registration registration) {
		// TODO Auto-generated method stub
		registrationDAOImpl.addNewRegistration(registration);
		
	}

	@Override
	public Registration getRegistration(int registrationId) {
		// TODO Auto-generated method stub
		return registrationDAOImpl.getRegistration(registrationId);
	}


	@Override
	public List<Registration> displayAllRegistration() {
		// TODO Auto-generated method stub
		return registrationDAOImpl.displayAllRegistration();
	}

	@Override
	public void updateRegistration(int registrationId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		registrationDAOImpl.updateRegistration(registrationId, columnName, newValue);
		
	}

}
