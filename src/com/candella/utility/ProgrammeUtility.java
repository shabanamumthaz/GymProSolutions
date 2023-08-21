package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.Programme;
import com.candella.entity.Trainer;
import com.candella.service.ProgrammeServiceImpl;
import com.candella.service.TrainerServiceImpl;

public class ProgrammeUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		programmeMenu();

	}

	public static void programmeMenu() {
		// TODO Auto-generated method stub
		

		ProgrammeServiceImpl programmeServiceImpl = new ProgrammeServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueStatus;
		
		do
		{
		System.out.println("*********************MENU**********************");
		System.out.println("1.Add Programme        2.Update Programme    3.Display All Programme     4.Get Programme  ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			addProgramme();
			break;
		case 2:
			updateProgramme();
			break;
		case 3:
			displayAllProgramme();
			break;
		case 4:
			getProgramme();

		}
		System.out.println("Do you want to continue?");
		 continueStatus=scanner.next().charAt(0);
		}
		while(continueStatus=='Y'||continueStatus=='y');
		 if(continueStatus!='y')
		 {
			MainUtility.mainMenu(); 
		 }
	}

	public static void getProgramme() {
		// TODO Auto-generated method stub
		ProgrammeServiceImpl programmeServiceImpl=new ProgrammeServiceImpl();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Programme id:");
		int programmeId=scanner.nextInt();
		
		Programme  programme=programmeServiceImpl.getProgramme(programmeId);
		
	}

	public static void displayAllProgramme() {
		// TODO Auto-generated method stub
		ProgrammeServiceImpl programmeServiceImpl=new ProgrammeServiceImpl();

		List<Programme> programmeList = programmeServiceImpl.displayAllProgramme();
		System.out.println("Programme Id           programme Name       Description       Programme price      Schedule");
		for (Programme programme : programmeList) {
			System.out.println(programme.getProgrammeId()+"         "+ programme.getProgrammeName() +"         "+ programme.getDescription()
					+"         "+ programme.getProgrammePrice() +"         "+ programme.getSchedule()+"         "+programme.getNoOfDays()+"         "+programme.getAttendancePerWeek());
		}
		
	}

	private static void updateProgramme() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ProgrammeServiceImpl programmeServiceImpl=new ProgrammeServiceImpl();
		
		System.out.println("Enter Programme ID:");
		int programmeId=scanner.nextInt();
		Programme programme=programmeServiceImpl.getProgramme(programmeId);
		char continueChoice;
		
		if(programme!=null)
		{
		
		do
		{
		System.out.println("Enter which field of programme to be updated:");
		System.out.println("1.programme Name   2.Description  3.Programme price  4.programme Schedule");
		int option =scanner.nextInt();
		//ProgrammeServiceImpl programmeServiceImpl=new ProgrammeServiceImpl();
		String columnName=null;
		
		
		
		switch(option)
		
		{
		case 1:
			 columnName="Programme_Name";
			System.out.println("Enter new first name:");
			scanner.nextLine();
			String updatedName =scanner.nextLine();
			programmeServiceImpl.updateProgramDetails(programmeId,columnName,updatedName);	
			
			break;
			
		case 2:
			 columnName="Description";
			System.out.println("Enter description to be updated :");
			scanner.nextLine();
			String newDescription =scanner.nextLine();
			programmeServiceImpl.updateProgramDetails(programmeId,columnName,newDescription);	
			
			break;
			
			
		case 3:
			 columnName="Programme_price";
			System.out.println("Enter updated programme price");
			scanner.nextLine();
			String updatedPrice =scanner.nextLine();
			programmeServiceImpl.updateProgramDetails(programmeId,columnName,updatedPrice);		
			
			break;
		case 4:
			 columnName="schedule";
				System.out.println("Enter the updated schedule:");
				scanner.nextLine();
				String updatedSchedule =scanner.nextLine();
				programmeServiceImpl.updateProgramDetails(programmeId,columnName,updatedSchedule);
				
				break;
				
		case 5:
			 columnName="NoOfDays";
				System.out.println("Enter the no of days to b updated:");
				scanner.nextLine();
				String updatedDays =scanner.nextLine();
				programmeServiceImpl.updateProgramDetails(programmeId,columnName,updatedDays);
				
				break;
				
		case 6:
			 columnName="AttendancePerWeek";
				System.out.println("Enter the no of days to b updated:");
				scanner.nextLine();
				String updatedDay =scanner.nextLine();
				programmeServiceImpl.updateProgramDetails(programmeId,columnName,updatedDay);
				
				break;
				default:
					break;
		}
		System.out.println("Do you want to continue?");
		 continueChoice=scanner.next().charAt(0);
		}
		while(continueChoice=='Y'||continueChoice=='y');
		
		
		}
		else 
			System.out.println("Invalid Id");
		
		
	}

	private static void addProgramme() {
		// TODO Auto-generated method stub
		ProgrammeServiceImpl programmeServiceImpl=new ProgrammeServiceImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Programme Id:");
		int programmeId=scanner.nextInt();
		System.out.println("Enter Programme Name:");
		scanner.nextLine();
		String programmeName=scanner.nextLine();
		System.out.println("Enter  Description:");
		String programmeDescription=scanner.nextLine();
		System.out.println("Enter programme price:");
		double programmePrice=scanner.nextDouble();
		System.out.println("Enter  Schedule:");
		scanner.nextLine();
		String programmeSchedule=scanner.nextLine();
		System.out.println("Enter the days of programme:");
		int noOfDays=scanner.nextInt();
		System.out.println("Enter the Attendence per week for perticular proframme:");
		int noOfDay=scanner.nextInt();
		
		
	Programme programme=new Programme(programmeId,programmeName,programmeDescription,programmePrice,programmeSchedule,noOfDays,noOfDay);
	programmeServiceImpl.addProgramme(programme);
		
	}
	

		
	}


