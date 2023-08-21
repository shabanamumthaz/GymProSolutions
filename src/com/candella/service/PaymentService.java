package com.candella.service;

import java.util.List;


import com.candella.entity.Payment;

public interface PaymentService {
	public void addPayment(Payment payment);
	public Payment getPayment(int paymentId);
	public List<Payment> displayAllPayment();

}
