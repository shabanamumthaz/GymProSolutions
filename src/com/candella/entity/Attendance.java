package com.candella.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Attendance {

	private int attendenceId;
	private Registration registration;
	private LocalDate date;
	private LocalDateTime timeIn;
	private LocalDateTime timeOut;
	private String status;
	
	
	
	public Attendance(int attendenceId, Registration registration, LocalDate date, String status) {
		super();
		this.attendenceId = attendenceId;
		this.registration = registration;
		this.date = date;
		this.status = status;
	}
	public Attendance(int attendenceId, Registration registration, LocalDate date, LocalDateTime timeIn,
			LocalDateTime timeOut, String status) {
		super();
		this.attendenceId = attendenceId;
		this.registration = registration;
		this.date = date;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.status = status;
	}
	public int getAttendenceId() {
		return attendenceId;
	}
	public void setAttendenceId(int attendenceId) {
		this.attendenceId = attendenceId;
	}
	public Registration getRegistration() {
		return registration;
	}
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(LocalDateTime timeIn) {
		this.timeIn = timeIn;
	}
	public LocalDateTime getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Attendance(Registration registration, LocalDate date, LocalDateTime timeIn, LocalDateTime timeOut,
			String status) {
		super();
		this.registration = registration;
		this.date = date;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.status = status;
	}
	public Attendance(Registration registration, LocalDate date, String status) {
		super();
		this.registration = registration;
		this.date = date;
		this.status = status;
	}
	
	
	
}
