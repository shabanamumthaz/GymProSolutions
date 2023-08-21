package com.candella.service;

import java.util.List;

import com.candella.dao.ProgrammeDAOImpl;
import com.candella.entity.Programme;

public class ProgrammeServiceImpl implements ProgrammeService {
	
	ProgrammeDAOImpl programmeDAOImpl=new ProgrammeDAOImpl();

	@Override
	public void addProgramme(Programme programme) {
		// TODO Auto-generated method stub
		programmeDAOImpl.addProgramme(programme);
		
	}

	@Override
	public Programme getProgramme(int programmeId) {
		// TODO Auto-generated method stub
		return programmeDAOImpl.getProgramme(programmeId);
		 
	}

	@Override
	public void updateProgramDetails(int programmeId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		programmeDAOImpl.updateProgramDetails(programmeId, columnName, newValue);
		
		
	}

	@Override
	public List<Programme> displayAllProgramme() {
		// TODO Auto-generated method stub
		return  programmeDAOImpl.displayAllProgramme();
		
	}

	
	

}
