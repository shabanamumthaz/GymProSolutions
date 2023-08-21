package com.candella.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;

import com.candella.entity.LabortaryDetails;


public class LabortaryDetailsDAOImpl implements LabortaryDetailsDAO{

	@Override
	public void addLabortaryDetails(LabortaryDetails labortaryDetails) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into LabortaryDetails(lab_id,Name,Location)values(?,?,?)");
			
			preparedStatement.setInt(1,labortaryDetails.getLabId());
			preparedStatement.setString(2,labortaryDetails.getName());
			preparedStatement.setString(3,labortaryDetails.getLocation());
			
			preparedStatement.executeUpdate();
			System.out.println("Added successfully");
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public LabortaryDetails getLabortaryDetails(int labId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LabortaryDetails labortaryDetails=null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select* from LabortaryDetails where lab_id=?");
			preparedStatement.setInt(1, labId);
			ResultSet resultSet = preparedStatement.executeQuery();
			

			if (resultSet.next()) {

			 labortaryDetails=new LabortaryDetails(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return labortaryDetails;
		
	}

	@Override
	public void updateLabortaryDetails(int labId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();

		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update labortaryDetails set " + columnName + "= ? where lab_id=?");
			

			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, labId);
			preparedStatement.executeUpdate();
			
			connection.close();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		
	}
	}

	@Override
	public List<LabortaryDetails> displayAll() {
		// TODO Auto-generated method stub
		List<LabortaryDetails> LabortaryDetailsList = new ArrayList<LabortaryDetails>();
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from LabortaryDetails");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				LabortaryDetails labortaryDetails=new LabortaryDetails(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
				LabortaryDetailsList.add(labortaryDetails);
			}
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return LabortaryDetailsList;
	}

}
