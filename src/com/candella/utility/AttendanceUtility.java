package com.candella.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.canddella.mail.MailSender;
import com.candella.entity.Attendance;
import com.candella.entity.Registration;
import com.candella.service.AttendanceServiceImpl;
import com.candella.service.RegistrationServiceImpl;

public class AttendanceUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		attendanceMenu();

	}

	public static void attendanceMenu() {
		// TODO Auto-generated method stub
		AttendanceServiceImpl attendanceServiceImpl = new AttendanceServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueStatus;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println(
					"1.Mark Attendance          2.Display All Attendance   3.Get Attendance   4.Weekly AttendList");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addAttendance();
				break;

			case 2:
				displayAllAttendance();
				break;
			case 3:
				getAttendance();
				break;

			case 4:
				getShortageAttendanceList();

			}
			System.out.println("Do you want to continue?");
			continueStatus = scanner.next().charAt(0);
		} while (continueStatus == 'Y' || continueStatus == 'y');
		 if(continueStatus!='y')
		 {
			MainUtility.mainMenu(); 
		 }
	}

	private static void getShortageAttendanceList() {
		// TODO Auto-generated method stub
		AttendanceServiceImpl attendanceServiceImpl = new AttendanceServiceImpl();
		List<Attendance> attendanceList = attendanceServiceImpl.displayAllAttendance();

		LocalDate date = null;

		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();

		System.out.println("Enter start date");
		String startDate = scanner.nextLine();
		LocalDate sDate = LocalDate.parse(startDate, formater);

		List<Registration> registrationList = registrationServiceImpl.displayAllRegistration();

		int count = 0;
		LocalDate activeDate = null;
		List <String> mailList = new ArrayList<>();

		int i=0;
		for (Registration registration : registrationList) {
			activeDate = sDate;
			
			for (Attendance attendance : attendanceList) {
				if (activeDate.equals(sDate.plusDays(8))) {
					break;
				}
				if (attendance.getDate().equals(activeDate)
						&& attendance.getRegistration().getRegId() == registration.getRegId()) {
					count++;
					activeDate = activeDate.plusDays(1);
				}

			}

			if (count < 4) {

				System.out.println("Members Name       | Programme Name        | DaysOfAbsent");
				System.out.println("---------------------------------------------------");

				// for (Registration registerObj : attendanceShortageList)
				// Replace 'attendanceShortageList' with the actual variable name

				String memberName = registration.getGym_member().getFirstName();
				String programmeName = registration.getProgramme().getProgrammeName();
				mailList.add(registration.getGym_member().getEmailId());

				System.out.printf("%-20s | %-20s | %d%n", memberName, programmeName, count);
				i++;
				

			}

			count = 0;

		}
		String[] mails = new String[mailList.size()];
		for(i=0;i<mailList.size();i++)
		{
			mails[i]=mailList.get(i);
		}
		//MailSender.sendMailToMultiple(mails, "Absent Warning", "You have failed to obtain the minimum 4 days attendance for the programme, Please attend or state your reason to the gym manager");
	}

	private static Attendance getAttendance() {
		// TODO Auto-generated method stub
		AttendanceServiceImpl attendanceServiceImpl = new AttendanceServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Attendance id:");
		int attendanceId = scanner.nextInt();

		Attendance attendance = attendanceServiceImpl.getAttendance(attendanceId);

		return attendance;
	}

	private static void displayAllAttendance() {
		// TODO Auto-generated method stub
		AttendanceServiceImpl attendanceServiceImpl = new AttendanceServiceImpl();
		List<Attendance> attendanceList = attendanceServiceImpl.displayAllAttendance();

		System.out
				.println("Attendance ID  |  Registration ID  |  Date        |  Time In      |  Time Out     |  Status");
		System.out
				.println("------------------------------------------------------------------------------------------");

		for (Attendance attendance : attendanceList) {
			String timeIn = attendance.getTimeIn() != null ? attendance.getTimeIn().toString() : "null";
			String timeOut = attendance.getTimeOut() != null ? attendance.getTimeOut().toString() : "null";

			String output = String.format("%-15d | %-17d | %-12s | %-13s | %-13s | %s", attendance.getAttendenceId(),
					attendance.getRegistration().getRegId(), attendance.getDate(), timeIn, timeOut,
					attendance.getStatus());
			System.out.println(output);
		}

	}

	private static void addAttendance() {
		// TODO Auto-generated method stub

		AttendanceServiceImpl attendanceServiceImpl = new AttendanceServiceImpl();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		Scanner scanner = new Scanner(System.in);

		RegistrationUtility.displayAllRegistration();
		System.out.println("Enter register Id:");
		int registerId = scanner.nextInt();
		RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();
		Registration registration = registrationServiceImpl.getRegistration(registerId);

		if (registration != null) {
			System.out.println("Enter  Date:");
			scanner.nextLine();
			String aDate = scanner.nextLine();
			LocalDate date = LocalDate.parse(aDate, formatter);
			System.out.println("1.Mark Present   2. Mark Absent");
			int choice = scanner.nextInt();
			String status = null;
			Attendance attendance = null;
			if (choice == 1) {
				System.out.println("Enter Time In:");
				scanner.nextLine();
				String tIn = scanner.nextLine();
				LocalDateTime timein = LocalDateTime.parse(tIn, timeformatter);

				System.out.println("Enter Time Out:");
				String tOut = scanner.nextLine();
				LocalDateTime timeOut = LocalDateTime.parse(tOut, timeformatter);
				status = "Present";
				attendance = new Attendance(registration, date, timein, timeOut, status);

			} else if (choice == 2) {
				status = "Absent";
				attendance = new Attendance(registration, date, status);
			}

			attendanceServiceImpl.addAttendance(attendance);

		} else {
			System.out.println("Invalid Registration ID");
		}

	}

}
