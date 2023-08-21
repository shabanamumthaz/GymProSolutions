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

public class GymMemberDAOImpl implements GymMemberDAO {
	
	@Override
	public void addMembers(GymMember gymMember) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd");
		
		DataSource dataSource = DBConnectionPool.getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into Gym_Member(member_id,first_Name,last_name,date_of_birth,gender,email,phone_number,address,emergency_contact_name,emergency_contact_phone)values(?,?,?,?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1,gymMember.getMemberId());
			preparedStatement.setString(2,gymMember.getFirstName());
			preparedStatement.setString(3,gymMember.getLastName());
			Date date=Date.valueOf(gymMember.getDateOfBirth());
			preparedStatement.setDate(4,date);
			preparedStatement.setString(5,gymMember.getGender());
			preparedStatement.setString(6,gymMember.getEmailId());
			preparedStatement.setString(7,gymMember.getPhoneNumber());
			preparedStatement.setString(8,gymMember.getAddress());
			preparedStatement.setString(9,gymMember.getEmergencyContactName());
			preparedStatement.setString(10,gymMember.getEmergencyContactPhoneNo());
			
			preparedStatement.executeUpdate();	
			System.out.println("Added successfully");
			connection.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateMembers(int memberId, String columName, String newValue) {
		// TODO Auto-generated method stub
		DataSource dataSource =DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try
		{
			
			
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update gym_member set "+columName+"= ? where member_id=?");
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, memberId);
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
	public GymMember getMember(int memberId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		GymMember gymMember=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select* from gym_member where member_id=?");
			preparedStatement.setInt(1,memberId);
			ResultSet resultSet=preparedStatement.executeQuery();	
			
			
			 if(resultSet.next())
			{
				 LocalDate dob=LocalDate.parse(resultSet.getString(4),formatter);
				 gymMember=new GymMember(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),dob,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
			}
			 connection.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return gymMember;
		
	}

	@Override
	public List<GymMember> displayAllMember() {
		// TODO Auto-generated method stub
		List<GymMember> memberList=new ArrayList<GymMember>();
		DataSource dataSource=DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		GymMember gymMember=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select * from gym_member");
			ResultSet resultSet=preparedStatement.executeQuery();	
			
		while(resultSet.next())
		{
			
			 LocalDate dob=LocalDate.parse(resultSet.getString(4),formatter);
			 gymMember=new GymMember(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),dob,resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),
					 resultSet.getString(9),resultSet.getString(10));
			 
			 memberList.add(gymMember);
		}
		connection.close();
		}
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return memberList;
		
	}
	}

