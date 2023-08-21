package com.candella.service;

import java.util.List;

import com.candella.dao.BillDAOImpl;
import com.candella.entity.Bill;

public class BillServiceImpl implements BillService{
	
	BillDAOImpl billDAOImpl=new BillDAOImpl();
	@Override
	public void addBill(Bill bill) {
		// TODO Auto-generated method stub
		billDAOImpl.addBill(bill);
		
	}

	@Override
	public Bill getBill(int billId) {
		// TODO Auto-generated method stub
		return billDAOImpl.getBill(billId);
	}

	@Override
	public void updateBills(int billId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		billDAOImpl.updateBills(billId, columnName, newValue);
		
	}

	@Override
	public List<Bill> displayAllBill() {
		// TODO Auto-generated method stub
		return billDAOImpl.displayAllBill();
	}

}
