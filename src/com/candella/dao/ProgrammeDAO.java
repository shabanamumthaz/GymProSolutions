package com.candella.dao;

import java.util.List;

import com.candella.entity.Programme;

public interface ProgrammeDAO {
	
	public void addProgramme(Programme programme);
	public Programme getProgramme(int programmeId);
	public void updateProgramDetails(int programmeId ,String columnName,String newValue);
	public List<Programme> displayAllProgramme();
	

}
