package com.candella.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.candella.entity.GymMember;
import com.candella.service.GymMemberServiceImpl;

public class MemberUtility {

	public static void main(String[] args) {

		GymMember();

	}

	public static void GymMember() {

		GymMemberServiceImpl gymMemberServiceImpl = new GymMemberServiceImpl();
		Scanner scanner = new Scanner(System.in);
		char continueChoice;

		do {
			System.out.println("*********************MENU**********************");
			System.out
					.println("1.Add Member        2.Update MemberDetails    3.Display All Member      4.Get Member  ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				addMembers();
				break;

			case 2:
				updateMembers();
				break;

			case 3:
				displayAllMember();
				break;

			case 4:
				getMember();
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next().charAt(0);
		} while (continueChoice == 'Y' || continueChoice == 'y');
		 if(continueChoice!='y')
		 {
			MainUtility.mainMenu(); 
		 }

	}

	public static void displayAllMember() {
		// TODO Auto-generated method stub
		GymMemberServiceImpl gymMemberServiceImpl = new GymMemberServiceImpl();
		List<GymMember> memberList = gymMemberServiceImpl.displayAllMember();

		System.out.println(
				"member Id           Member First Name        Member Last Name       Email Id       Phone Number      Address      DateOfBirth       Emergency Contact Name         Emergency Contact Number     ");
		for (GymMember member : memberList) {

			System.out.println(member.getMemberId() + "       " + member.getFirstName() + "       "
					+ member.getLastName() + "       " + member.getEmailId() + "       " + member.getPhoneNumber()
					+ member.getAddress() + "       " + member.getDateOfBirth() + "       "
					+ member.getEmergencyContactName() + "       " + member.getEmergencyContactPhoneNo());
		}

	}

	private static void updateMembers() {
		// TODO Auto-generated method stub
		GymMemberServiceImpl gymMemberServiceImpl = new GymMemberServiceImpl();
		Scanner scanner = new Scanner(System.in);
		String columnName = null;
		char continueChoice;
		System.out.println("Enter Member ID:");
		int memberID = scanner.nextInt();
		GymMember gymMemberObj = gymMemberServiceImpl.getMember(memberID);

		if (gymMemberObj != null) {

			do {
				System.out.println("Enter which field of member to be updated:");
				System.out.println("1.FisrtName  2.LastName  3.DateOfBirth  4.Gender  5.EmailID  "
						+ "6.PhoneNumber  7.Address  8.Emergency ContactName  9.Emergency Phone Number");
				int option = scanner.nextInt();

				switch (option) {
				case 1:
					columnName = "first_name";
					System.out.println("Enter new first name:");
					scanner.nextLine();
					String newFirstName = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newFirstName);

					break;

				case 2:
					columnName = "last_name";
					System.out.println("Enter new last name:");
					scanner.nextLine();
					String newLastName = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newLastName);

					break;

				case 3:
					columnName = "date_of_birth";
					System.out.println("Enter new date of birth name:");
					scanner.nextLine();
					String newDob = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newDob);

					break;
				case 4:
					columnName = "Gender";
					System.out.println("Enter Gender:");
					scanner.nextLine();
					String newGender = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newGender);

					break;

				case 5:
					columnName = "email";
					System.out.println("Enter email id:");
					scanner.nextLine();
					String newEmailId = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newEmailId);

					break;

				case 6:
					columnName = "phone_number";
					System.out.println("Enter phone number:");
					scanner.nextLine();
					String newPhoneNumber = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newPhoneNumber);

					break;

				case 7:
					columnName = "address";
					System.out.println("Enter address:");
					scanner.nextLine();
					String newAddress = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newAddress);

					break;

				case 8:
					columnName = "emergency_contact_name";
					System.out.println("Enter emergency contact name:");
					scanner.nextLine();
					String newEmergencyConName = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newEmergencyConName);

					break;

				case 9:
					columnName = "emergency_contact_phone number";
					System.out.println("Enter address:");
					scanner.nextLine();
					String newEmergencyPhoneNum = scanner.nextLine();
					gymMemberServiceImpl.updateMembers(memberID, columnName, newEmergencyPhoneNum);

					break;
				}

				System.out.println("Do you want to continue?");
				continueChoice = scanner.next().charAt(0);
			} while (continueChoice == 'Y' || continueChoice == 'y');

		} else
			System.out.println("Invalid Id");

	}

	public static void addMembers() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		GymMemberServiceImpl gymMemberServiceImpl = new GymMemberServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Member Id:");
		int memberId = scanner.nextInt();
		System.out.println("Enter Member First Name:");
		scanner.nextLine();
		String memberFstName = scanner.nextLine();
		System.out.println("Enter Member Last Name:");
		String memberLstName = scanner.nextLine();
		System.out.println("Enter Member date of Birth:");
		String memberDoB = scanner.nextLine();
		LocalDate dob = LocalDate.parse(memberDoB, formatter);
		System.out.println("Enter Gender :");
		String memberGender = scanner.nextLine();
		System.out.println("Enter Member email id:");
		String memberEmailId = scanner.nextLine();
		System.out.println("Enter Member Phone Number:");
		String memberPhoneNumber = scanner.nextLine();
		System.out.println("Enter  Address:");
		String memberAddress = scanner.nextLine();
		System.out.println("Enter emergency contact name :");
		String memberEmrgContactName = scanner.nextLine();
		System.out.println("Enter emergency contact phone number :");
		String memberEmrgContactPhNo = scanner.nextLine();

		GymMember gymMember = new GymMember(memberId, memberFstName, memberLstName, dob, memberGender, memberEmailId,
				memberPhoneNumber, memberAddress, memberEmrgContactName, memberEmrgContactPhNo);

		gymMemberServiceImpl.addMembers(gymMember);

	}

	private static void getMember() {
		// TODO Auto-generated method stub
		GymMemberServiceImpl gymMemberServiceImpl = new GymMemberServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Member id:");
		int memId = scanner.nextInt();

		GymMember gymMember = gymMemberServiceImpl.getMember(memId);

	}
}
