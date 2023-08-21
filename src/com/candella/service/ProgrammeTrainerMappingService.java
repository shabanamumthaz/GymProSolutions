package com.candella.service;

import java.util.List;

import com.candella.entity.ProgrammeTrainerMapping;

public interface ProgrammeTrainerMappingService {
	
	 public ProgrammeTrainerMapping getProgrammeTrainerMapping(int mappingId);
		
		public List<ProgrammeTrainerMapping> displayAllProgrammeTrainerMapping();

}
