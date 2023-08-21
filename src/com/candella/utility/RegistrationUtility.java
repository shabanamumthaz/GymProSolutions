package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.dao.RegistrationDAOImpl;
import com.candella.entity.GymMember;
import com.candella.entity.Programme;
import com.candella.entity.Registration;
import com.candella.entity.Trainer;
import com.candella.service.ProgrammeServiceImpl;
import com.candella.service.RegistrationServiceImpl;

public class RegistrationUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Registration();

	}

	public static void Registration() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char continueStatus = 0;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println(
					"1.Add Registration        2.Update Registration     3.Display All Registrations     4.Get Registrations  ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addNewRegistration();
				break;
			case 2:
				updateRegistration();
				break;
			case 3:
				displayAllRegistration();
				break;
			case 4:
				getRegistration();
				break;
			}

			System.out.println("Do you want to continue?");
			continueStatus = scanner.next().charAt(0);
		}

		while (continueStatus == 'Y' || continueStatus == 'y');
		 if(continueStatus!='y')
		 {
			MainUtility.mainMenu(); 
		 }

	}

	public static void getRegistration() {
		// TODO Auto-generated method stub

		RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();
		ProgrammeServiceImpl programmeServiceImpl=new ProgrammeServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter registration id:");
		int registrationId = scanner.nextInt();

		Registration registration = registrationServiceImpl.getRegistration(registrationId);
		
		Programme programme = programmeServiceImpl.getProgramme(registration.getProgramme().getProgrammeId());
		System.out.println("The Amount to be paid is:"+programme.getProgrammePrice());

	}

	public static void displayAllRegistration() {
		// TODO Auto-generated method stub

		RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();

		List<Registration> registrationList = registrationServiceImpl.displayAllRegistration();
		
		System.out.println("Registration ID        Member ID     Programme ID     Trainer ID       Start Date      End Date");
		for (Registration registration : registrationList) {
			System.out.println("          "+registration.getRegId() + "          "+registration.getGym_member().getMemberId()
					+ "          "+ registration.getProgramme().getProgrammeId() + "          "+ registration.getTrainer().getTrainerId()
					+  "          "+registration.getStartDate().toString() + "          "+ registration.getEndDate().toString());

		}

	}

	private static void updateRegistration() {
		// TODO Auto-generated method stub
		
		RegistrationServiceImpl registrationServiceImpl = new RegistrationServiceImpl();
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Registration ID:");
		int registrationId=scanner.nextInt();
		Registration registration=registrationServiceImpl.getRegistration(registrationId);
		char continueChoice;
		
		if(registration!=null)
		{
		
		do
		{
		System.out.println("Enter which field of registration to be updated:");
		System.out.println("1.Start Date   2.End Date  ");
		int option =scanner.nextInt();
		
		String columnName=null;
		
		
		
		switch(option)
		
		{
		case 1:
			 columnName="start_Date";
			System.out.println("Enter the start Date to be edited:(yyyy-mm-dd)");
			scanner.nextLine();
			String newStartDate =scanner.nextLine();
			registrationServiceImpl.updateRegistration(registrationId, columnName, newStartDate);
				
			
			break;
			
		case 2:
			 columnName="end_Date";
				System.out.println("Enter the end Date to be edited:(yyyy-mm-dd)");
				scanner.nextLine();
				String newEndDate =scanner.nextLine();
				registrationServiceImpl.updateRegistration(registrationId, columnName, newEndDate);
			
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

	private static void addNewRegistration() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		RegistrationDAOImpl registrationDAOImpl = new RegistrationDAOImpl();
		
		
		displayAllRegistration();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Registration Id:");
		int registrationId = scanner.nextInt();
		
		memberDetails();
		//*********************member id to be added to registration table****************************8
		System.out.println("Enter member Id:");
		int memberId = scanner.nextInt();
		GymMember member = new GymMember();
		member.setMemberId(memberId);
		
		programmeDetails();

		System.out.println("Enter Programme Id:");
		int programmeId = scanner.nextInt();
		Programme programme = new Programme();
		programme.setProgrammeId(programmeId);

		trainerDetails();

		System.out.println("Enter Trainer Id:");
		int trainerId = scanner.nextInt();
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerId);
		System.out.println("Enter Membership start Date:");
		scanner.nextLine();
		String startDate = scanner.nextLine();
		LocalDate sDate = LocalDate.parse(startDate, formatter);
		System.out.println("Enter MemberShip End Date:");
		String endDate = scanner.nextLine();
		LocalDate eDate = LocalDate.parse(endDate, formatter);

		Registration registration = new Registration(registrationId, member, programme, trainer, sDate, eDate);

		registrationDAOImpl.addNewRegistration(registration);
		System.out.println("Do you want Labortary Services:1.Yes   2.No");
		int choice=scanner.nextInt();
		if(choice==1)
		{
			labortaryServiceMenu();
		}
		else if(choice==2)
		{
			System.out.println("Registration completed");
		}
		

	}

	private static void labortaryServiceMenu() {
		// TODO Auto-generated method stub
		
		LabServiceUtility.addLabService();
		

		
	}

	private static void memberDetails() {
		// TODO Auto-generated method stub
		MemberUtility memberUtility=new MemberUtility();
		memberUtility.displayAllMember();
		
	}

	private static void trainerDetails() {
		// TODO Auto-generated method stub
		TrainerUtility trainerUtility=new TrainerUtility();
		trainerUtility.displayAllTrainer();
		
	}

	private static void programmeDetails() {
		// TODO Auto-generated method stub
		ProgrammeUtility programmeUtility=new ProgrammeUtility();
		programmeUtility.displayAllProgramme();
	}

}
