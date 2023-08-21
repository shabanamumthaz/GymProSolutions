package com.candella.service;

import java.util.List;

import com.candella.dao.AttendanceDAOImpl;
import com.candella.entity.Attendance;

public class AttendanceServiceImpl implements AttendanceService{

	AttendanceDAOImpl attendanceDAOImpl=new AttendanceDAOImpl();
	
	@Override
	public void addAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		
		attendanceDAOImpl.addAttendance(attendance);
		
		
	}

	@Override
	public Attendance getAttendance(int attendanceId) {
		// TODO Auto-generated method stub
		return attendanceDAOImpl.getAttendance(attendanceId);
	}


	@Override
	public List<Attendance> displayAllAttendance() {
		// TODO Auto-generated method stub
		return attendanceDAOImpl.displayAllAtendance();
	}

	

}
