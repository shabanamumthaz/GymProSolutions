package com.candella.service;

import java.util.List;

import com.candella.dao.LabServiceDAOImpl;
import com.candella.entity.LabService;

public class LabServiceServiceImpl implements LabServiceService{
	
	LabServiceDAOImpl LabServiceDAOImpl=new LabServiceDAOImpl();

	@Override
	public void addLabService(LabService labService) {
		// TODO Auto-generated method stub
		LabServiceDAOImpl.addLabService(labService);
		
	}

	@Override
	public LabService getLabService(int serviceId) {
		// TODO Auto-generated method stub
		return LabServiceDAOImpl.getLabService(serviceId);
	}

	@Override
	public void updateLabServiceDetails(int serviceId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		LabServiceDAOImpl.updateLabServiceDetails(serviceId, columnName, newValue);
		
	}

	@Override
	public List<LabService> displayAllLabService() {
		// TODO Auto-generated method stub
		return LabServiceDAOImpl.displayAllLabService();
	}

}
