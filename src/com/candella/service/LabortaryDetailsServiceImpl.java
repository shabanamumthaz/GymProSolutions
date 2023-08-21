package com.candella.service;

import java.util.List;

import com.candella.dao.LabortaryDetailsDAOImpl;
import com.candella.entity.LabortaryDetails;

public class LabortaryDetailsServiceImpl implements LabortaryDetailsService{
	
	LabortaryDetailsDAOImpl labortaryDetailsDAOImpl =new LabortaryDetailsDAOImpl();

	@Override
	public void addLabortaryDetails(LabortaryDetails LabortaryDetails) {
		// TODO Auto-generated method stub
		labortaryDetailsDAOImpl.addLabortaryDetails(LabortaryDetails);
		
	}

	@Override
	public LabortaryDetails getLabortaryDetails(int labId) {
		// TODO Auto-generated method stub
		return labortaryDetailsDAOImpl.getLabortaryDetails(labId);
	}

	@Override
	public void updateLabortaryDetails(int labId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		
		labortaryDetailsDAOImpl.updateLabortaryDetails(labId, columnName, newValue);
		
	}

	@Override
	public List<LabortaryDetails> displayAll() {
		// TODO Auto-generated method stub
		return labortaryDetailsDAOImpl.displayAll();
	}

}
