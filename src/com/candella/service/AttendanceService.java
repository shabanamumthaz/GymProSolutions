package com.candella.service;

import java.util.List;

import com.candella.entity.Attendance;

public interface AttendanceService {
	
	public void addAttendance(Attendance attendance);
	public Attendance getAttendance(int attendanceId);
	public List<Attendance> displayAllAttendance();

}
