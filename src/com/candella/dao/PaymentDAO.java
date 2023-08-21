package com.candella.dao;

import java.util.List;


import com.candella.entity.Payment;

public interface PaymentDAO {
	
	public void addPayment(Payment payment);
	public Payment getPayment(int paymentId);
	public List<Payment> displayAllPayment();

}
