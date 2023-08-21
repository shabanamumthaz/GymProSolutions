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
import com.candella.entity.Equipment;


public class EquipmentDAOImpl implements EquipmentDAO{

	@Override
	public void addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		//DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into equipment(equipment_Name,description,purchase_date,equipment_condition,equipment_price)values(?,?,?,?,?)");
			
			preparedStatement.setString(1,equipment.getEquipmentName());
			preparedStatement.setString(2,equipment.getDescription());
			Date purchaseDate=Date.valueOf(equipment.getPurchaseDate());
			preparedStatement.setDate(3,purchaseDate);
			preparedStatement.setString(4,equipment.getEquipmentCondition());
			preparedStatement.setDouble(5,equipment.getEquipmentPrice());
			
			preparedStatement.executeUpdate();	
			System.out.println("Added successfully");
			connection.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Equipment getEquipment(int equipmentId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
		Equipment equipment=null;
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select* from equipment where equipment_id=?");
			preparedStatement.setInt(1,equipmentId);
			ResultSet resultSet=preparedStatement.executeQuery();	
			
			
			 if(resultSet.next())
			{
				LocalDate purchaseDate =LocalDate.parse(resultSet.getString(4),formatter);
				equipment =new Equipment(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),purchaseDate,resultSet.getString(5),resultSet.getDouble(6));
			}
			 connection.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return equipment;
		
	}

	@Override
	public void updateEquipmentDetails(int equipmentId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		DataSource dataSource =DBConnectionPool.getDataSource();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try
		{
			
			
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update equipment set "+columnName+"= ? where equipment_id=?");
			String date=columnName;
			if (columnName==date)
			{
				Date purchaseDate =Date.valueOf(newValue);
				preparedStatement.setDate(1, purchaseDate);
				preparedStatement.setInt(2, equipmentId);
			}
			else
			{
			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, equipmentId);
			}
			preparedStatement.executeUpdate();
			
			connection.close();
		}	
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Equipment> displayAllEquipment() {
		// TODO Auto-generated method stub
		List<Equipment> equipmentList=new ArrayList<Equipment>();
		DataSource dataSource=DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try
		{
			Connection connection=dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("Select * from equipment");
			ResultSet resultSet=preparedStatement.executeQuery();	
			
		while(resultSet.next())
		{
			LocalDate purchaseDate=LocalDate.parse(resultSet.getString(4),formatter);
			Equipment equipment=new Equipment(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),purchaseDate,resultSet.getString(5),resultSet.getDouble(6));
			 
			 equipmentList.add(equipment);
		}
		connection.close();
		}
		
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return equipmentList;
	}

}
