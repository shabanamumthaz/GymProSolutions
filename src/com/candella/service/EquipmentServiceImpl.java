package com.candella.service;

import java.util.List;

import com.candella.dao.EquipmentDAOImpl;
import com.candella.entity.Equipment;

public class EquipmentServiceImpl implements EquipmentService{
	
	EquipmentDAOImpl equipmentDAOImpl=new EquipmentDAOImpl();

	@Override
	public void addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		equipmentDAOImpl.addEquipment(equipment);
		
	}

	@Override
	public Equipment getEquipment(int equipmentId) {
		// TODO Auto-generated method stub
		return equipmentDAOImpl.getEquipment(equipmentId);
	}

	@Override
	public void updateEquipmentDetails(int equipmentId, String columnName, String newValue) {
		// TODO Auto-generated method stub
		equipmentDAOImpl.updateEquipmentDetails(equipmentId, columnName, newValue);
		
	}

	@Override
	public List<Equipment> displayAllEquipment() {
		// TODO Auto-generated method stub
		return equipmentDAOImpl.displayAllEquipment();
	}

}
