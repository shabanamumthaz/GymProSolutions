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

import com.candella.entity.Registration;

public class BillDAOImpl implements BillDAO {

	@Override
	public void addBill(Bill bill) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into bills(bill_number,bill_date,due_date,reg_id,total_amount)values(?,?,?,?,?)");

			preparedStatement.setString(1, bill.getBillNumber());
			Date billDate = Date.valueOf(bill.getBillDate());
			preparedStatement.setDate(2, billDate);
			Date dueDate = Date.valueOf(bill.getDueDate());
			preparedStatement.setDate(3, dueDate);
			preparedStatement.setInt(4, bill.getRegistration().getRegId());
			preparedStatement.setDouble(5, bill.getTotalAmount());

			preparedStatement.executeUpdate();
			System.out.println("Added successfully");
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Bill getBill(int billId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Bill bill = null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select* from bills where bill_id=?");
			preparedStatement.setInt(1, billId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				LocalDate billDate = LocalDate.parse(resultSet.getString(3), formatter);
				LocalDate dueDate = LocalDate.parse(resultSet.getString(4), formatter);
				Registration registration = new Registration();
				registration.setRegId(resultSet.getInt(5));
				bill = new Bill(resultSet.getInt(1), resultSet.getString(2), billDate, dueDate, registration,
						resultSet.getDouble(6));
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bill;

	}

	@Override
	public void updateBills(int billId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();

		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update bills set " + columnName + "= ? where bill_id=?");
			if (columnName == "bill_date") {
				Date billDate = Date.valueOf(newValue);
				preparedStatement.setDate(1, billDate);
				preparedStatement.setInt(2, billId);
			} else if (columnName == "due_date") {
				Date dueDate = Date.valueOf(newValue);
				preparedStatement.setDate(1, dueDate);
				preparedStatement.setInt(2, billId);
			}

			preparedStatement.setString(1, newValue);
			preparedStatement.setInt(2, billId);
			preparedStatement.executeUpdate();
			
			connection.close();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Bill> displayAllBill() {
		// TODO Auto-generated method stub
		List<Bill> billList = new ArrayList<Bill>();
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from bills");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LocalDate billDate = LocalDate.parse(resultSet.getString(3), formatter);
				LocalDate dueDate = LocalDate.parse(resultSet.getString(4), formatter);
				Registration registration = new Registration();
				registration.setRegId(resultSet.getInt(5));
				Bill bills = new Bill(resultSet.getInt(1), resultSet.getString(2), billDate, dueDate, registration,
						resultSet.getDouble(6));

				billList.add(bills);
			}
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return billList;
		
	}

}
