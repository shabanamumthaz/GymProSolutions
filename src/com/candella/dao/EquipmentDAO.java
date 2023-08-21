package com.candella.dao;

import java.util.List;

import com.candella.entity.Equipment;



public interface EquipmentDAO {
	
	public void addEquipment(Equipment equipment);
	public Equipment getEquipment(int equipmentId);
	public void updateEquipmentDetails(int equipmentId ,String columnName,String newValue);
	public List<Equipment> displayAllEquipment();

}
