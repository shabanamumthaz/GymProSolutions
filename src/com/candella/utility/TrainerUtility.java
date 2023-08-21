package com.candella.utility;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.GymMember;
import com.candella.entity.Trainer;
import com.candella.service.TrainerServiceImpl;

public class TrainerUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trainer();

	}

	public static void Trainer() {
		// TODO Auto-generated method stub

		TrainerServiceImpl trainerServiceImpl = new TrainerServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueStatus;
		
		do
		{
		System.out.println("*********************MENU**********************");
		System.out.println("1.Add Trainer        2.Update TrainerDetails    3.Display All Trainer     4.Get Trainer  ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			addTrainer();
			break;
		case 2:
			updateTrainer();
			break;
		case 3:
			displayAllTrainer();
			break;
		case 4:
			getTrainer();
			break;

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
	

	private static void getTrainer() {
		// TODO Auto-generated method stub
		TrainerServiceImpl trainerServiceImpl = new TrainerServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Trainer id:");
		int trainerId = scanner.nextInt();

		Trainer trainer = trainerServiceImpl.getTrainer(trainerId);

	}

	public static void displayAllTrainer() {
		// TODO Auto-generated method stub

		TrainerServiceImpl trainerServiceImpl = new TrainerServiceImpl();

		List<Trainer> trainerList = trainerServiceImpl.displayAllTrainer();
		System.out.println("Trainer Id           Trainer Name       EmailID       Phone Number      Specialization");
		for (Trainer trainer : trainerList) {
			System.out.println(trainer.getTrainerId() +"           "+ trainer.getTrainerName() +"           "+ trainer.getEmailId()
			+"           "+ trainer.getPhoneNumber() +"           "+ trainer.getSpecialization());

		}

	}

	

	private static void updateTrainer() {
		// TODO Auto-generated method stub
		TrainerServiceImpl trainerServiceImpl = new TrainerServiceImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter trainer ID:");
		int trainerId=scanner.nextInt();
		Trainer trainer=trainerServiceImpl.getTrainer(trainerId);
		char continueChoice;
		
		if(trainer!=null)
		{
		
		do
		{
		System.out.println("Enter which field of trainer to be updated:");
		System.out.println("1.Trainer Name   2.EmailID  3.PhoneNumber  4.Specialization");
		int option =scanner.nextInt();
		TrainerServiceImpl trainerServiceImpl1 = new TrainerServiceImpl();
		String columnName=null;
		
		
		
		switch(option)
		
		{
		case 1:
			 columnName="Name";
			System.out.println("Enter new first name:");
			scanner.nextLine();
			String newName =scanner.nextLine();
			trainerServiceImpl1.updateTrainer(trainerId,columnName,newName);	
			
			break;
			
		case 2:
			 columnName="email";
			System.out.println("Enter new Email id:");
			scanner.nextLine();
			String newEmailId =scanner.nextLine();
			trainerServiceImpl1.updateTrainer(trainerId,columnName,newEmailId);	
			
			break;
			
			
		case 3:
			 columnName="phone";
			System.out.println("Enter new phone number:");
			scanner.nextLine();
			String newPhoneNumber =scanner.nextLine();
			trainerServiceImpl1.updateTrainer(trainerId,columnName,newPhoneNumber);	
			
			break;
		case 4:
			 columnName="specialization";
				System.out.println("Enter the data to be updated:");
				scanner.nextLine();
				String newSpecialization =scanner.nextLine();
				trainerServiceImpl1.updateTrainer(trainerId,columnName,newSpecialization);
				
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

	private static void addTrainer() {
		// TODO Auto-generated method stub
		TrainerServiceImpl trainerServiceImpl = new TrainerServiceImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Trainer Id:");
		int trainerId=scanner.nextInt();
		System.out.println("Enter  Name:");
		scanner.nextLine();
		String trainerName=scanner.nextLine();
		System.out.println("Enter  email id:");
		String trainerEmailId=scanner.nextLine();
		System.out.println("Enter Phone Number:");
		long trainerPhoneNumber=scanner.nextLong();
		System.out.println("Enter  Specialization:");
		scanner.nextLine();
		String trainerSpecialization=scanner.nextLine();
		
		
		Trainer trainer =new Trainer(trainerId,trainerName,trainerEmailId,trainerPhoneNumber,trainerSpecialization);
		
		trainerServiceImpl.addTrainer(trainer);
	
		

	}

}
