package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.LabService;
import com.candella.entity.LabortaryDetails;
import com.candella.entity.Registration;
import com.candella.service.LabServiceServiceImpl;

public class LabServiceUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LabServiceMenu();

	}

	public static void LabServiceMenu() {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		char continueStatus;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println("1.Add ServiceDetails           2.Display All Services    3.Get ServiceDetails      4.serviceRemainder ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addLabService();
				break;
			case 2:
				displayAllLabService();
				break;
			case 3:
				getLabService();
				break;
			case 4:
				serviceRemainder();

			}
			System.out.println("Do you want to continue?");
			continueStatus = scanner.next().charAt(0);
		} while (continueStatus == 'Y' || continueStatus == 'y');
		 if(continueStatus!='y')
		 {
			MainUtility.mainMenu(); 
		 }

	}

	private static void serviceRemainder() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the date of service");
		String startDate =scanner.nextLine();
		LocalDate sDate = LocalDate.parse(startDate, formatter);
		
		if(sDate.equals(sDate))
		
		
		
		
		
		
	}

	private static void getLabService() {
		// TODO Auto-generated method stub
		LabServiceServiceImpl labServiceServiceImpl = new LabServiceServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Service id:");
		int serviceId = scanner.nextInt();

		LabService labService = labServiceServiceImpl.getLabService(serviceId);

	}

	private static void displayAllLabService() {
		// TODO Auto-generated method stub
		LabServiceServiceImpl labServiceServiceImpl = new LabServiceServiceImpl();
		List<LabService> serviceList = labServiceServiceImpl.displayAllLabService();

		System.out.println(
				"Service ID         Lab Id        Reg ID      ServiceDescription      Status      date Of Service");
		for (LabService labService : serviceList) {
			System.out.println(labService.getLabServiceId() + "          " + labService.getLabortaryDetails().getLabId()
					+ "          " + labService.getRegistration().getRegId() + "          "
					+ labService.getServiceDescription() + "            " + labService.getStatus() + "        "
					+ labService.getDateOfService());
		}

	}

	public static void addLabService() {
		// TODO Auto-generated method stub
		
		LabServiceServiceImpl labServiceServiceImpl = new LabServiceServiceImpl();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Scanner scanner=new Scanner(System.in);
		
		 System.out.println("Enter service Id:"); 
		 int serviceId=scanner.nextInt();
		 System.out.println("Enter register Id:"); 
		 int regId=scanner.nextInt();
		 Registration registration=new Registration();
		 registration.setRegId(regId);
		 System.out.println("Enter lab Id:"); 
		 int labId=scanner.nextInt();
		 LabortaryDetails labortaryDetails=new LabortaryDetails();
		 labortaryDetails.setLabId(labId);
		 
		System.out.println("Enter Service Description:");
		scanner.nextLine();
		String serviceDescription=scanner.nextLine();
		System.out.println("Status:");
		String status=scanner.nextLine();
		System.out.println("Enter Date of service:");
		String sDate=scanner.nextLine();
		LocalDate serviceDate=LocalDate.parse(sDate, formatter);
		scanner.nextLine();
		
		LabService labService=new LabService(serviceId,registration,labortaryDetails,serviceDescription,status,serviceDate);
		labServiceServiceImpl.addLabService(labService);

	}

}
