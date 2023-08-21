package com.candella.dao;

import java.util.List;


import com.candella.entity.LabortaryDetails;

public interface LabortaryDetailsDAO {
	
	public void addLabortaryDetails(LabortaryDetails  LabortaryDetails);
	public LabortaryDetails getLabortaryDetails(int labId);
	public void updateLabortaryDetails(int labId ,String columnName,String newValue);
	public List<LabortaryDetails> displayAll();

}
