package com.candella.dao;

import java.util.List;

import com.candella.entity.EquipmentMaintanenceStaffInfo;


public interface EquipMaintanenceStaffDAO {
	
	public void addStaffInfo(EquipmentMaintanenceStaffInfo equipmentMaintanenceStaffInfo);
	public EquipmentMaintanenceStaffInfo getStaffInfo(int staffId);
	public void updateStaffInfo(int staffId,String columnName,String newValue);
	public List<EquipmentMaintanenceStaffInfo> displayAllStaffInfo();

}
