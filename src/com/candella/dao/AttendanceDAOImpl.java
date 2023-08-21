package com.candella.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.candella.dbconnectionpool.DBConnectionPool;
import com.candella.entity.Attendance;

import com.candella.entity.Registration;




public class AttendanceDAOImpl implements AttendanceDAO{

	@Override
	public void addAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			Connection connection = dataSource.getConnection();
			
			
			if(attendance.getStatus().equalsIgnoreCase("Present"))
			{
				PreparedStatement preparedStatement = connection.prepareStatement(
						"Insert into Attendance(reg_id,date,time_in,time_out,attendanceStatus)values(?,?,?,?,?)");

				
				preparedStatement.setInt(1,attendance.getRegistration().getRegId());
				Date date = Date.valueOf(attendance.getDate());
				preparedStatement.setDate(2, date);
				Timestamp timeIn=Timestamp.valueOf(attendance.getTimeIn());
				Timestamp timeOut=Timestamp.valueOf(attendance.getTimeOut());
				preparedStatement.setTimestamp(3,timeIn);
				preparedStatement.setTimestamp(4,timeOut);
				preparedStatement.setString(5, attendance.getStatus());

				preparedStatement.executeUpdate();
				System.out.println("Added successfully");
				
			}
			
			

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Attendance getAttendance(int attendanceId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Attendance attendance=null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select* from attendance where attendanceId=?");
			preparedStatement.setInt(1, attendanceId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

				LocalDate date = LocalDate.parse(resultSet.getString(3), formatter);
				Timestamp timeStamp=resultSet.getTimestamp(4);
				LocalDateTime localDateTime=timeStamp.toLocalDateTime();
				Timestamp timeStmp=resultSet.getTimestamp(5);
				LocalDateTime localDateTimeOut=timeStmp.toLocalDateTime();
				Registration registration=new Registration();
				registration.setRegId(resultSet.getInt(2)); 
				
				
				attendance=new Attendance(resultSet.getInt(1),registration,date,localDateTime,localDateTimeOut,resultSet.getString(6));
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return attendance;
		
	}

	@Override
	public List<Attendance> displayAllAtendance() {
		// TODO Auto-generated method stub
		List<Attendance> attendanceList = new ArrayList<Attendance>();
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from attendance");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Attendance attendance=null;
				LocalDate date = LocalDate.parse(resultSet.getString(3), formatter);
				Registration registration=new Registration();
				registration.setRegId(resultSet.getInt(2)); 
				if(resultSet.getString(4)!=null || resultSet.getString(5)!=null)
				{
				Timestamp timeStamp=resultSet.getTimestamp(4);
				LocalDateTime localDateTime=timeStamp.toLocalDateTime();
				Timestamp timeStmp=resultSet.getTimestamp(5);
				LocalDateTime localDateTimeOut=timeStmp.toLocalDateTime();
				attendance=new Attendance(resultSet.getInt(1),registration,date,localDateTime,localDateTimeOut,resultSet.getString(6));

				}
				else
				{
					

				
					attendance = new Attendance(resultSet.getInt(1), registration, date, resultSet.getString(6));

				}
				
				
				
				attendanceList.add(attendance);
			}
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return attendanceList;
		
	}

}
