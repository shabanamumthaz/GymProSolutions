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
import com.candella.entity.Payment;


public class PaymentDAOImpl implements PaymentDAO{

	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		// DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into payment (payment_id,bill_id,payment_date,payment_method,amount,notes)values(?,?,?,?,?,?)");

			preparedStatement.setInt(1,payment.getPaymentId());
			preparedStatement.setInt(2,payment.getBill().getBillId());
			Date billDate = Date.valueOf(payment.getPaymentDate());
			preparedStatement.setDate(3, billDate);
			preparedStatement.setString(4,payment.getPaymentMethod());
			preparedStatement.setDouble(5,payment.getAmount());
			preparedStatement.setString(6,payment.getNotes());

			preparedStatement.executeUpdate();
			System.out.println("Added successfully");
			
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public Payment getPayment(int paymentId) {
		// TODO Auto-generated method stub
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	Payment payment=null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select* from payment where payment_id=?");
			preparedStatement.setInt(1, paymentId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				LocalDate paymentDate = LocalDate.parse(resultSet.getString(3), formatter);
				Bill bill=new Bill();
				bill.setBillId(resultSet.getInt(3));
				payment=new Payment(resultSet.getInt(1),bill,paymentDate,resultSet.getString(4),resultSet.getDouble(5),resultSet.getString(6));
			}
			connection.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return payment;
		
	}


	@Override
	public List<Payment> displayAllPayment() {
		// TODO Auto-generated method stub
		List<Payment> paymentList = new ArrayList<Payment>();
		DataSource dataSource = DBConnectionPool.getDataSource();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from payment");
			ResultSet resultSet = preparedStatement.executeQuery();
	

			while (resultSet.next()) {
				LocalDate paymentDate = LocalDate.parse(resultSet.getString(3), formatter);
				
				Bill bill=new Bill();
				bill.setBillId(resultSet.getInt(2));
				Payment payment=new Payment(resultSet.getInt(1),bill,paymentDate,resultSet.getString(4),resultSet.getDouble(5),resultSet.getString(6));
				

				paymentList.add(payment);
			}
			connection.close();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return paymentList;
		
	}

}
