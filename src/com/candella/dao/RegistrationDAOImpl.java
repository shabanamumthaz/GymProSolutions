package com.candella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.GymMember;
import com.candella.entity.Programme;
import com.candella.entity.Registration;
import com.candella.entity.Trainer;
import com.candella.service.GymMemberServiceImpl;
import com.candella.service.ProgrammeServiceImpl;

public class RegistrationDAOImpl implements RegistrationDAO {

	@Override
	public void addNewRegistration(Registration registration) {
		// TODO Auto-generated method stub

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");

		DataSource dataSource = DBConnectionPool.getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("Insert into registration values(?,?,?,?,?,?)");

			preparedStatement.setInt(1, registration.getRegId());
			preparedStatement.setInt(2, registration.getGym_member().getMemberId());
			preparedStatement.setInt(3, registration.getProgramme().getProgrammeId());
			preparedStatement.setInt(4, registration.getTrainer().getTrainerId());
			Date startDate = Date.valueOf(registration.getStartDate());
			Date endDate = Date.valueOf(registration.getEndDate());
			preparedStatement.setDate(5, startDate);
			preparedStatement.setDate(6, endDate);

			preparedStatement.executeUpdate();
			System.out.println("Added successfully");
			
			PreparedStatement prepareStatement = connection
					.prepareStatement("Insert into absentCount values(?,?)");
			prepareStatement.setInt(1, registration.getRegId());
			prepareStatement.setInt(2, 0);
			
			prepareStatement.executeUpdate();
			

			
			
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Registration getRegistration(int registrationId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Registration registration=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select * from registration where reg_id=?");
			preparedStatement.setInt(1,registrationId);
			
			
			
			ResultSet resultSet=preparedStatement.executeQuery();	
			
			
			 if(resultSet.next())
			{
				 GymMember gymMember = new GymMember();
					Trainer trainer = new Trainer();
					Programme programme = new Programme();
					programme.setProgrammeId(resultSet.getInt(3));
					gymMember.setMemberId(resultSet.getInt(2));
					trainer.setTrainerId(resultSet.getInt(4));
					LocalDate sDate=LocalDate.parse(resultSet.getString(5),formatter);
					LocalDate eDate=LocalDate.parse(resultSet.getString(6),formatter);
				 
				 registration=new Registration(resultSet.getInt(1),gymMember,programme,trainer,sDate,eDate);
			}
			 connection.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return registration;
	
	}

	@Override
	public void updateRegistration(int registrationId, String columnName, String newValue) {

		DataSource dataSource = DBConnectionPool.getDataSource();

		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Registration set " + columnName + "= ? where reg_id=?");
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, registrationId);
			preparedStatement.executeUpdate();
			
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Registration> displayAllRegistration() {
		GymMemberServiceImpl gymMemberServiceImpl = new GymMemberServiceImpl();
		ProgrammeServiceImpl ProgrammeServiceImpl=new ProgrammeServiceImpl();
		
		// TODO Auto-generatednew method stub
		List<Registration> registrationList = new ArrayList<Registration>();
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from registration");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GymMember gymMember = gymMemberServiceImpl.getMember(resultSet.getInt(2));
				Trainer trainer = new Trainer();
				Programme programme = ProgrammeServiceImpl.getProgramme(resultSet.getInt(3));
				//Programme programme = new Programme();
				int regId=resultSet.getInt(1);

				//programme.setProgrammeId(resultSet.getInt(3));
				
				trainer.setTrainerId(resultSet.getInt(4));
				LocalDate sDate=LocalDate.parse(resultSet.getString(5),formatter);
				LocalDate eDate=LocalDate.parse(resultSet.getString(6),formatter);
				Registration registration = new Registration(regId,gymMember,programme,trainer,sDate,eDate);

				registrationList.add(registration);
			}
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return registrationList;

	}

}
