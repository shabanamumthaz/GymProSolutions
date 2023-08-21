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

public class ProgrammeDAOImpl implements ProgrammeDAO {

	@Override
	public void addProgramme(Programme programme) {
		// TODO Auto-generated method stubDateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd");
		
		DataSource dataSource = DBConnectionPool.getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into programme(programme_id,programme_Name,description,programme_price,schedule,NoOfDays,AttendencePerWeek)values(?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1,programme.getProgrammeId());
			preparedStatement.setString(2,programme.getProgrammeName());
			preparedStatement.setString(3,programme.getDescription());
			preparedStatement.setDouble(4,programme.getProgrammePrice());
			preparedStatement.setString(5,programme.getSchedule());
			preparedStatement.setInt(6,programme.getNoOfDays());
			preparedStatement.setInt(7,programme.getAttendancePerWeek());
			
			
			preparedStatement.executeUpdate();	
			System.out.println("Added successfully");
			connection.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Programme getProgramme(int programmeId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Programme programme=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select* from programme where programme_id=?");
			preparedStatement.setInt(1,programmeId);
			ResultSet resultSet=preparedStatement.executeQuery();	
			
			
			 if(resultSet.next())
			{
				
				 programme=new Programme(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7));
			}
			 connection.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return programme;
		
	}

	@Override
	public void updateProgramDetails(int programmeId,String columnName,String newValue) {
		// TODO Auto-generated method stub
		DataSource dataSource =DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try
		{
			
			
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update programme set "+columnName+"= ? where programme_id=?");
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, programmeId);
			preparedStatement.executeUpdate();
//		while(resultSet.next())
//		{
//			LocalDate dob=LocalDate.parse(resultSet.getString(4), formatter);
//			GymMember gymMember=new GymMember(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),dob,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
//		}
			connection.close();
			
		}	
			
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Programme> displayAllProgramme() {
		// TODO Auto-generated method stub
		List<Programme> programmeList=new ArrayList<Programme>();
		DataSource dataSource=DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		GymMember gymMember=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select * from programme");
			ResultSet resultSet=preparedStatement.executeQuery();	
			
		while(resultSet.next())
		{
			
			Programme programme=new Programme(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getDouble(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7));
			 
			 programmeList.add(programme);
		}
		connection.close();
		}
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return programmeList;
		
	}

}
