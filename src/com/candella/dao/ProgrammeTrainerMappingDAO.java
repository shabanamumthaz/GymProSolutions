package com.candella.dao;

import java.util.List;

import com.candella.entity.ProgrammeTrainerMapping;



public interface ProgrammeTrainerMappingDAO {
	
    public ProgrammeTrainerMapping getProgrammeTrainerMapping(int mappingId);
	
	public List<ProgrammeTrainerMapping> displayAllProgrammeTrainerMapping();


}
