package com.candella.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.GymMember;
import com.candella.entity.Programme;
import com.candella.entity.ProgrammeTrainerMapping;
import com.candella.entity.Trainer;

public class ProgrammeTrainerMappingDAOImpl implements ProgrammeTrainerMappingDAO{

	@Override
	public ProgrammeTrainerMapping getProgrammeTrainerMapping(int mappingId) {
		// TODO Auto-generated method stub
		
		DataSource dataSource = DBConnectionPool.getDataSource();
		
		ProgrammeTrainerMapping programmeTrainerMapping=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select * from ProgrammeTrainerMapping where mapping_id=?");
			preparedStatement.setInt(1,mappingId);
			
			
			
			ResultSet resultSet=preparedStatement.executeQuery();	
			
			
			 if(resultSet.next())
			{
				 GymMember gymMember = new GymMember();
					Trainer trainer = new Trainer();
					Programme programme = new Programme();
					programme.setProgrammeId(resultSet.getInt(3));
					gymMember.setMemberId(resultSet.getInt(2));
					trainer.setTrainerId(resultSet.getInt(4));
					
				 
					programmeTrainerMapping=new ProgrammeTrainerMapping(resultSet.getInt(1),programme,trainer,gymMember);
			}
			 connection.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return programmeTrainerMapping;
		
		
	}

	@Override
	public List<ProgrammeTrainerMapping> displayAllProgrammeTrainerMapping() {
		// TODO Auto-generated method stub
		List<ProgrammeTrainerMapping> programmeTrainerMappingList = new ArrayList<ProgrammeTrainerMapping>();
		DataSource dataSource = DBConnectionPool.getDataSource();
		

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from registration");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GymMember gymMember = new GymMember();
				Trainer trainer = new Trainer();
				Programme programme = new Programme();
				int mappingId=resultSet.getInt(1);
				gymMember.setMemberId(resultSet.getInt(2));
				programme.setProgrammeId(resultSet.getInt(3));
				
				trainer.setTrainerId(resultSet.getInt(4));
				
				ProgrammeTrainerMapping programmeTrainerMapping = new ProgrammeTrainerMapping(mappingId,programme,trainer,gymMember);

				programmeTrainerMappingList.add(programmeTrainerMapping);
			}
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return programmeTrainerMappingList;
		
		
	}

}
