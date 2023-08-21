package com.candella.service;

import java.util.List;

import com.candella.dao.PaymentDAOImpl;
import com.candella.entity.Payment;

public class PaymentServiceImpl implements PaymentService{
	
	PaymentDAOImpl paymentDAOImpl=new PaymentDAOImpl();

	@Override
	public void addPayment(Payment payment) {
		// TODO Auto-generated method stub
		paymentDAOImpl.addPayment(payment);
		
	}

	@Override
	public Payment getPayment(int paymentId) {
		// TODO Auto-generated method stub
		return paymentDAOImpl.getPayment(paymentId);
	}

	@Override
	public List<Payment> displayAllPayment() {
		// TODO Auto-generated method stub
		return paymentDAOImpl.displayAllPayment();
	}

}
