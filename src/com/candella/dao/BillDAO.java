package com.candella.dao;

import java.util.List;

import com.candella.entity.Bill;


public interface BillDAO {
	
	public void addBill(Bill bill);
	public Bill getBill(int billId);
	public void updateBills(int billId ,String columnName,String newValue);
	public List<Bill> displayAllBill();

}
