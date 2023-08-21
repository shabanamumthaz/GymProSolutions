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
import com.candella.entity.Bill;
import com.candella.entity.LabService;
import com.candella.entity.LabortaryDetails;
import com.candella.entity.Registration;

public class LabServiceDAOImpl implements LabServiceDAO{

	@Override
	public void addLabService(LabService labService) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into labortaryServices(reg_id,lab_id,serviceDescription,status,dateOfService) values(?,?,?,?,?)");

			preparedStatement.setInt(1,labService.getRegistration().getRegId());
			preparedStatement.setInt(2,labService.getLabortaryDetails().getLabId());
			preparedStatement.setString(3,labService.getServiceDescription());
			preparedStatement.setString(4,labService.getStatus());
			Date dateOfService = Date.valueOf(labService.getDateOfService());
			preparedStatement.setDate(5, dateOfService);
			

			preparedStatement.executeUpdate();
			System.out.println("Added successfully");
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public LabService getLabService(int serviceId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LabService labService=null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select* from labortaryServices where LabServiceId_id=?");
			preparedStatement.setInt(1, serviceId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				LocalDate dateOfService = LocalDate.parse(resultSet.getString(6), formatter);
				Registration registration = new Registration();
				registration.setRegId(resultSet.getInt(2));
				LabortaryDetails labortaryDetails=new LabortaryDetails();
				labortaryDetails.setLabId(resultSet.getInt(3));
				
				 labService=new LabService(resultSet.getInt(1),registration,labortaryDetails,resultSet.getString(4),resultSet.getString(5),dateOfService);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return labService;
	
	}

	@Override
	public void updateLabServiceDetails(int serviceId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LabService> displayAllLabService() {
		// TODO Auto-generated method stub
		List<LabService> labServiceList = new ArrayList<LabService>();
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from LabortaryServices");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LocalDate dateOfService = LocalDate.parse(resultSet.getString(6), formatter);
				Registration registration = new Registration();
				registration.setRegId(resultSet.getInt(2));
				LabortaryDetails labortaryDetails=new LabortaryDetails();
				labortaryDetails.setLabId(resultSet.getInt(3));
				
				LabService labService=new LabService(resultSet.getInt(1),registration,labortaryDetails,resultSet.getString(4),resultSet.getString(5),dateOfService);
					
				labServiceList.add(labService);
				
			}
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return labServiceList;
	}
	
	

}
