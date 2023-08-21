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
import com.candella.entity.Trainer;

public class TrainerDAOImpl implements TrainerDAO{

	@Override
	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
		
		DataSource dataSource = DBConnectionPool.getDataSource();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into trainer (trainer_id,Name,email,phone,specialization)values(?,?,?,?,?)");
			preparedStatement.setInt(1,trainer.getTrainerId());
			preparedStatement.setString(2,trainer.getTrainerName());
			preparedStatement.setString(3,trainer.getEmailId());
			
			preparedStatement.setLong(4,trainer.getPhoneNumber());
			preparedStatement.setString(5,trainer.getSpecialization());
			
			preparedStatement.executeUpdate();	
			System.out.println("Added successfully");
			connection.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Trainer getTrainer(int trainerId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Trainer trainer=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select * from trainer where trainer_id=?");
			preparedStatement.setInt(1,trainerId);
			
			
			
			ResultSet resultSet=preparedStatement.executeQuery();	
			
			
			 if(resultSet.next())
			{
				 
				 trainer=new Trainer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4),resultSet.getString(5));
			}
			 connection.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return trainer;
		
	}

	@Override
	public void updateTrainer(int trainerId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		
		DataSource dataSource =DBConnectionPool.getDataSource();
	
		try
		{
			
			
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update trainer set "+columnName+"= ? where trainer_id=?");
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, trainerId);
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
	public List<Trainer> displayAllTrainer() {
		// TODO Auto-generated method stub
		
			List<Trainer> trainerList=new ArrayList<Trainer>();
			DataSource dataSource=DBConnectionPool.getDataSource();
		
			Trainer trainer=null;
			try
			{
				Connection connection=dataSource.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("Select * from trainer");
				ResultSet resultSet=preparedStatement.executeQuery();	
				
			while(resultSet.next())
			{
				
			 trainer=new Trainer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getLong(4),resultSet.getString(5));	
			
				 
				 trainerList.add(trainer);
			}
			connection.close();
			}
			
			
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			return trainerList;
			
		}
	

		
	}

	

	


