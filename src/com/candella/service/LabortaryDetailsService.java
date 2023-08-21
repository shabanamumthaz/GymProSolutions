package com.candella.service;

import java.util.List;

import com.candella.entity.LabortaryDetails;

public interface LabortaryDetailsService {
	
	public void addLabortaryDetails(LabortaryDetails  LabortaryDetails);
	public LabortaryDetails getLabortaryDetails(int labId);
	public void updateLabortaryDetails(int labId ,String columnName,String newValue);
	public List<LabortaryDetails> displayAll();
	
	

}
