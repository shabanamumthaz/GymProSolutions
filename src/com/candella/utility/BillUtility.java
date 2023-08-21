package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Bill;
import com.candella.entity.Programme;
import com.candella.entity.Registration;
import com.candella.service.BillServiceImpl;

public class BillUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		billMenu();

	}

	public static void billMenu() {
		// TODO Auto-generated method stub
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueStatus;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println(
					"1.Add Bill        2.Update Bill    3.Display All Bills    4.Get Bill  ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addBill();
				break;
			case 2:
				updateBill();
				break;
			case 3:
				displayAllBill();
				break;
			case 4:
				getBill();
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

	private static void getBill() {
		// TODO Auto-generated method stub
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter bill id:");
		int billId = scanner.nextInt();

		Bill bill = billServiceImpl.getBill(billId);
		
	}

	public static void displayAllBill() {
		// TODO Auto-generated method stub
		
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		List<Bill> billList = billServiceImpl.displayAllBill();
		
		System.out.println("Bill ID         Bill Number     Bill Date      Due Date    TotalAmount");
		for (Bill bill : billList) {
			System.out.println(bill.getBillId() +"          "+ bill.getBillNumber() +"          "+ bill.getBillDate()
			+"          "+ bill.getDueDate() +"          "+ bill.getTotalAmount());		}
		
	}

	private static void updateBill() {
		// TODO Auto-generated method stub
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Bill ID:");
		int billId=scanner.nextInt();
		
		Bill bill=billServiceImpl.getBill(billId);
		char continueChoice;
		
		if(bill!=null)
		{
		
		do
		{
		System.out.println("Enter which field of equipment to be updated:");
		System.out.println("1.Bill Number  2.Bill Date  3.Due Date 4.Amount ");
		int option =scanner.nextInt();
		
		String columnName=null;
		
		BillServiceImpl billServiceImple = new BillServiceImpl();
		
		switch(option)
		
		{
		case 1:
			 columnName="bill_number";
			System.out.println("Enter the bill number to be updated:");
			scanner.nextLine();
			String newBillNumber =scanner.nextLine();
			billServiceImple.updateBills(billId, columnName, newBillNumber);	
			
			break;
			
		case 2:
			 columnName="bill_date";
			System.out.println("Enter the bill date to be updated:");
			scanner.nextLine();
			String newBillDate=scanner.nextLine();
			billServiceImple.updateBills(billId, columnName, newBillDate);
			
			break;
			
			
		case 3:
			 columnName="due_date";
			System.out.println("Enter the due date to be updated:");
			scanner.nextLine();
			String newDueDate =scanner.nextLine();
			billServiceImple.updateBills(billId, columnName, newDueDate);
				
			
			break;
		case 4:
			 columnName="total_amount";
				System.out.println("Enter the amount to be updated:");
				scanner.nextLine();
				String newTotalAmount =scanner.nextLine();
				billServiceImple.updateBills(billId, columnName, newTotalAmount);
				
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

	private static void addBill() {
		// TODO Auto-generated method stub
		
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Scanner scanner=new Scanner(System.in);
		
		displayRegister();
		
		System.out.println("Enter reg Id:");
		int regId=scanner.nextInt();
		Registration registration =new Registration();
		registration.setRegId(regId);
		
		
		displayAllBill();
		
		 System.out.println("Enter Bill Id:"); 
		 int billId=scanner.nextInt();
		System.out.println("Enter Bill number:");
		scanner.nextLine();
		String billNumber=scanner.nextLine();
		System.out.println("Enter Bill Date:");
		String bDate=scanner.nextLine();
		LocalDate billDate=LocalDate.parse(bDate, formatter);
		System.out.println("Enter Due date:");
		String dDate=scanner.nextLine();
		LocalDate dueDate=LocalDate.parse(dDate, formatter);
		scanner.nextLine();
		amount();
		System.out.println("Enter amount:");
		double amount=scanner.nextDouble();
		
		Bill bill=new Bill(billId,billNumber,billDate,dueDate,registration,amount);
		billServiceImpl.addBill(bill);
		
	}

	

	private static void amount() {
		// TODO Auto-generated method stub
		RegistrationUtility  registrationUtility=new RegistrationUtility();
		
		registrationUtility.getRegistration();
		
		
		
	}

	private static void displayRegister() {
		// TODO Auto-generated method stub
		
		RegistrationUtility registerUtility=new RegistrationUtility();
		
		registerUtility.displayAllRegistration();
	}

	
		
	}


