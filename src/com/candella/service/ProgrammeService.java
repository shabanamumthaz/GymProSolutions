package com.candella.service;

import java.util.List;

import com.candella.entity.Programme;

public interface ProgrammeService {
	
	public void addProgramme(Programme programme);
	public Programme getProgramme(int programmeId);
	public void updateProgramDetails(int programmeId ,String columnName,String newValue);
	public List<Programme> displayAllProgramme();

}
