package com.candella.service;

import java.util.List;

import com.candella.dao.ProgrammeTrainerMappingDAOImpl;
import com.candella.entity.ProgrammeTrainerMapping;

public class ProgrammeTrainerMappingServiceImpl implements ProgrammeTrainerMappingService{
	
	ProgrammeTrainerMappingDAOImpl programmeTrainerMappingDAOImpl=new ProgrammeTrainerMappingDAOImpl();

	@Override
	public ProgrammeTrainerMapping getProgrammeTrainerMapping(int mappingId) {
		// TODO Auto-generated method stub
		return programmeTrainerMappingDAOImpl.getProgrammeTrainerMapping(mappingId);
	}

	@Override
	public List<ProgrammeTrainerMapping> displayAllProgrammeTrainerMapping() {
		// TODO Auto-generated method stub
		return programmeTrainerMappingDAOImpl.displayAllProgrammeTrainerMapping();
	}

}
