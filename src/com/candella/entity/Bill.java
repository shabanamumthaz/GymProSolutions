package com.candella.entity;

import java.time.LocalDate;

public class Bill {

	private int billId;
	private String billNumber;
	private LocalDate billDate;
	private LocalDate dueDate;
	private Registration registration;
	private double totalAmount;

	public Bill(int billId, String billNumber, LocalDate billDate, LocalDate dueDate, Registration registration,
			double totalAmount) {
		super();
		this.billId = billId;
		this.billNumber = billNumber;
		this.billDate = billDate;
		this.dueDate = dueDate;
		this.registration = registration;
		this.totalAmount = totalAmount;
	}

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
