package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Equipment;
import com.candella.entity.Trainer;
import com.candella.service.EquipmentServiceImpl;
import com.candella.service.TrainerServiceImpl;


public class EquipmentUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		equipmentMenu();

	}

	public static void equipmentMenu() {
		// TODO Auto-generated method stub
		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueStatus;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println(
					"1.Add Equipment        2.Update EquipmentDetails    3.Display All Equipments     4.Get Equipment  ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addEquipment();
				break;
			case 2:
				updateEquipmentDetails();
				break;
			case 3:
				displayAllEquipment();
				break;
			case 4:
				getEquipment();
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

	private static void getEquipment() {
		// TODO Auto-generated method stub
		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Equipment id:");
		int equipmentId = scanner.nextInt();

		Equipment equipment = equipmentServiceImpl.getEquipment(equipmentId);

	}

	private static void displayAllEquipment() {
		// TODO Auto-generated method stub
		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();

		List<Equipment> equipmentList = equipmentServiceImpl.displayAllEquipment();

		for (Equipment equipment : equipmentList) {
			System.out.println(equipment.getEquipmentId() + equipment.getEquipmentName() + equipment.getDescription()
					+ equipment.getEquipmentCondition() + equipment.getPurchaseDate() + equipment.getEquipmentPrice());

		}

	}

	private static void updateEquipmentDetails() {
		// TODO Auto-generated method stub
		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter equipment ID:");
		int equipmentId=scanner.nextInt();
		
		Equipment equipment=equipmentServiceImpl.getEquipment(equipmentId);
		char continueChoice;
		
		if(equipment!=null)
		{
		
		do
		{
		System.out.println("Enter which field of equipment to be updated:");
		System.out.println("1.Equipment Name   2.Equipment Description  3.Purchase Date  4.Equipment Condition 5.Price");
		int option =scanner.nextInt();
		EquipmentServiceImpl equipmentServiceImple = new EquipmentServiceImpl();
		String columnName=null;
		
		
		
		switch(option)
		
		{
		case 1:
			 columnName="equipment_name";
			System.out.println("Enter new first name:");
			scanner.nextLine();
			String newName =scanner.nextLine();
			equipmentServiceImple.updateEquipmentDetails(equipmentId, columnName, newName);	
			
			break;
			
		case 2:
			 columnName="description";
			System.out.println("Enter new description:");
			scanner.nextLine();
			String newDescription=scanner.nextLine();
			equipmentServiceImple.updateEquipmentDetails(equipmentId, columnName, newDescription);
			
			break;
			
			
		case 3:
			 columnName="purchase_date";
			System.out.println("Enter new Purchase date:");
			scanner.nextLine();
			String newPurchaseDate =scanner.nextLine();
			equipmentServiceImple.updateEquipmentDetails(equipmentId, columnName, newPurchaseDate);
				
			
			break;
		case 4:
			 columnName="equipment_condition";
				System.out.println("Enter equipment condition:");
				scanner.nextLine();
				String newCondition =scanner.nextLine();
				equipmentServiceImple.updateEquipmentDetails(equipmentId, columnName, newCondition);
				
				break;
		case 5:
			 columnName="equipment_price";
				System.out.println("Enter the price:");
				scanner.nextLine();
				String newPrice =scanner.nextLine();
				equipmentServiceImple.updateEquipmentDetails(equipmentId, columnName, newPrice);
				
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

	private static void addEquipment() {
		// TODO Auto-generated method stub
		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Scanner scanner=new Scanner(System.in);
		
		 System.out.println("Enter Equipment Id:"); 
		 int equipmentId=scanner.nextInt();
		System.out.println("Enter Equipment Name:");
		scanner.nextLine();
		String equipmentName=scanner.nextLine();
		System.out.println("Enter Equipment Description:");
		String equipmentDescription=scanner.nextLine();
		System.out.println("Enter Purchase date:");
		String equipmentPurchaseDate=scanner.nextLine();
		LocalDate purchaseDate=LocalDate.parse(equipmentPurchaseDate,formatter);
		System.out.println("Enter Equipment condition:");
		String equipmentCondition=scanner.nextLine();
		System.out.println("Enter Equipment price:");
		double equipmentPrice=scanner.nextDouble();
		
		Equipment equipment=new Equipment(equipmentId,equipmentName,equipmentDescription,purchaseDate,equipmentCondition,equipmentPrice);
		equipmentServiceImpl.addEquipment(equipment);
	}

}
