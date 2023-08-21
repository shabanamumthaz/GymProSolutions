package com.candella.dao;

import java.util.List;

import com.candella.entity.LabService;

public interface LabServiceDAO {
	
	public void addLabService(LabService labService);
	public LabService getLabService(int serviceId);
	public void updateLabServiceDetails(int serviceId ,String columnName,String newValue);
	public List<LabService> displayAllLabService();

}
