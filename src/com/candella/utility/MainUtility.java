package com.candella.utility;

import java.util.Scanner;

import com.canddella.mail.MailSender;

public class MainUtility {

	public static void main(String[] args) {
		
		mainMenu();
		//MailSender.sendMail("abhijithvfc22@gmail.com","Test", "Hellooooooo");
	}

	private static void attendenceCount() {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

	public static void mainMenu() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("***************************************************************");
		System.out.println("***********************GYmProSoLutions*************************");
		System.out.println("******************************Menu*****************************");
		System.out.println("***************************************************************");
		System.out.println("1.Gym Member\n2.Registration\n3.Bill\n4.Payment\n5.Programme\n6.Trainer\n7.Equipment \n8.Labortary Service");
		System.out.println("***************************************************************");
		int continueStatus=1;
		
		System.out.println("Enter your choice");
		
		int choice=scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			MemberUtility.GymMember();
			break;
		case 2:
			RegistrationUtility.Registration();
			break;
		case 3:
			BillUtility.billMenu();
			break;
		case 4:
			PaymentUtility.paymentMenu();
			break;
		case 5:
			ProgrammeUtility.programmeMenu();
			break;
		case 6:
			TrainerUtility.Trainer();
			break;
		case 7:
			EquipmentUtility.equipmentMenu();
			break;
		case 8:
			LabServiceUtility.LabServiceMenu();
		case 9:
			LabortaryUtility.labortaryMenu();
			break;
		case 10:
			AttendanceUtility.attendanceMenu();
			break;
			default:
				break;
		}
		
			
		
	}
	

}
