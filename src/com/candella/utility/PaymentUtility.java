package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.Bill;
import com.candella.entity.Payment;

import com.candella.service.PaymentServiceImpl;

public class PaymentUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		paymentMenu();

	}

	public static void paymentMenu() {
		// TODO Auto-generated method stub
		PaymentServiceImpl  PaymentServiceImpl=new PaymentServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueStatus;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println(
					"1.Add Payment           2.Display All Payments     3.Get Payment  ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addPayment();
				break;
			case 2:
				displayAllPayment();
				break;
			case 3:
				getPayment();
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

	private static void getPayment() {
		// TODO Auto-generated method stub
		PaymentServiceImpl  PaymentServiceImpl=new PaymentServiceImpl();
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter payment id:");
		int paymentId = scanner.nextInt();

		Payment payment = PaymentServiceImpl.getPayment(paymentId);
		
	}

	private static void displayAllPayment() {
		// TODO Auto-generated method stub
		PaymentServiceImpl  PaymentServiceImpl=new PaymentServiceImpl();
		List<Payment> paymentList = PaymentServiceImpl.displayAllPayment();
		
		//System.out.println("Payment ID         Bill Id     Payment Date      Payment Method      TotalAmount    notes");
		
		for (Payment payment : paymentList) {
			System.out.println(payment.getPaymentId() +"          "+ payment.getBill().getBillId() +"          "+ payment.getPaymentDate()
			+"          "+ payment.getPaymentMethod() +"          "+ payment.getNotes());		
			}
	}

	private static void addPayment() {
		// TODO Auto-generated method stub
		PaymentServiceImpl  PaymentServiceImpl=new PaymentServiceImpl();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter payment Id:");
		int paymentId=scanner.nextInt();
		displayAllBills();
		 System.out.println("Enter Bill Id:"); 
		 int billId=scanner.nextInt();
		 Bill bill=new Bill();
		 bill.setBillId(billId);
		 scanner.nextLine();
		System.out.println("Enter Payment Date:");
		String pDate=scanner.nextLine();
		LocalDate paymentDate=LocalDate.parse(pDate, formatter);
		System.out.println("Enter Payment Method:");
		String paymentMethod=scanner.nextLine();
		
		System.out.println("Enter amount:");
		double amount=scanner.nextDouble();
		System.out.println("Enter Payment notes:");
		scanner.nextLine();
		String paymentNotes=scanner.nextLine();
		
		Payment payment=new Payment(paymentId,bill,paymentDate,paymentMethod,amount,paymentNotes);
		
		PaymentServiceImpl.addPayment(payment);
		
	}

	private static void displayAllBills() {
		// TODO Auto-generated method stub
		BillUtility  billUtility=new BillUtility();
		BillUtility.displayAllBill();
	}

}
