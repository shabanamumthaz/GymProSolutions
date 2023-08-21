package com.candella.dao;

import java.util.List;

import com.candella.entity.Attendance;
import com.candella.entity.Bill;

public interface AttendanceDAO {
	
	public void addAttendance(Attendance attendance);
	public Attendance getAttendance(int attendanceId);
	public List<Attendance> displayAllAtendance();

}
