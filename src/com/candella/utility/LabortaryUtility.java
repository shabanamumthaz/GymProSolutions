package com.candella.utility;


import java.util.List;
import java.util.Scanner;


import com.candella.entity.LabortaryDetails;

import com.candella.service.LabortaryDetailsServiceImpl;

public class LabortaryUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		labortaryMenu();
		

	}

	public static void labortaryMenu() {
		// TODO Auto-generated method stub
		
		LabortaryDetailsServiceImpl labortaryDetailsServiceImpl = new LabortaryDetailsServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueStatus;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println(
					"1.Add Labortary Details        2.Update LabortaryDetails   3.Display All Details    4.Get LabortaryDetails  ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addLabDetails();
				break;
			case 2:
				updateLabDetails();
				break;
			case 3:
				displayAllDetails();
				break;
			case 4:
				getLabortaryDetails();
				break;

			}
			System.out.println("Do you want to continue?");
			continueStatus = scanner.next().charAt(0);
		} while (continueStatus == 'Y' || continueStatus == 'y');
		 if(continueStatus!='y')
		 {
			MainUtility.mainMenu(); 
		 }
	}

	private static void getLabortaryDetails() {
		// TODO Auto-generated method stub
		LabortaryDetailsServiceImpl labortaryDetailsServiceImpl = new LabortaryDetailsServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter labortary id:");
		int labId = scanner.nextInt();

		LabortaryDetails labortaryDetails = labortaryDetailsServiceImpl.getLabortaryDetails(labId);
		
	}

	private static void displayAllDetails() {
		// TODO Auto-generated method stub
		LabortaryDetailsServiceImpl labortaryDetailsServiceImpl = new LabortaryDetailsServiceImpl();
		List<LabortaryDetails> labortaryList = labortaryDetailsServiceImpl.displayAll();
		
		System.out.println("Labortary ID         Labortary Name    Location");
		for (LabortaryDetails labortaryDetails : labortaryList) {
			System.out.println(labortaryDetails.getLabId() +"          "+ labortaryDetails.getName() +"          "+ labortaryDetails.getLocation());	
			}
		
	}

	private static void updateLabDetails() {
		// TODO Auto-generated method stub
		LabortaryDetailsServiceImpl labortaryDetailsServiceImpl = new LabortaryDetailsServiceImpl();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Lab ID:");
		int labId=scanner.nextInt();
		
		LabortaryDetails labortaryDetails=labortaryDetailsServiceImpl.getLabortaryDetails(labId);
		char continueChoice;
		
		if(labortaryDetails!=null)
		{
		
		do
		{
		System.out.println("Enter which field of equipment to be updated:");
		System.out.println("1.Lab Name  2.Location  ");
		int option =scanner.nextInt();
		
		String columnName=null;
		
		LabortaryDetailsServiceImpl labortaryDetailsServiceImple = new LabortaryDetailsServiceImpl();
		
		switch(option)
		
		{
		case 1:
			 columnName="name";
			System.out.println("Enter the name to be updated:");
			scanner.nextLine();
			String name =scanner.nextLine();
			labortaryDetailsServiceImple.updateLabortaryDetails(labId, columnName, name);	
			
			break;
			
		case 2:
			 columnName="location";
			System.out.println("Enter the location to be updated:");
			scanner.nextLine();
			String location=scanner.nextLine();
			labortaryDetailsServiceImple.updateLabortaryDetails(labId, columnName, location);
			
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

	private static void addLabDetails() {
		// TODO Auto-generated method stub
		
		LabortaryDetailsServiceImpl labortaryDetailsServiceImple = new LabortaryDetailsServiceImpl();
		
		
		Scanner scanner=new Scanner(System.in);
		
		
		 System.out.println("Enter Lab Id:"); 
		 int labId=scanner.nextInt();
		System.out.println("Enter Lab name:");
		scanner.nextLine();
		String name=scanner.nextLine();
		System.out.println("Enter Location:");
		String location=scanner.nextLine();
		
		
		LabortaryDetails labortaryDetails=new LabortaryDetails(labId,name,location);
		
		labortaryDetailsServiceImple.addLabortaryDetails(labortaryDetails);
		
		
	}
		
		
		
	}


