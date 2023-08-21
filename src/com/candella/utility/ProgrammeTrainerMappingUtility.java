package com.candella.utility;

import java.util.List;
import java.util.Scanner;

import com.candella.entity.ProgrammeTrainerMapping;


import com.candella.service.ProgrammeTrainerMappingServiceImpl;


public class ProgrammeTrainerMappingUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		programmeTrainerMappingMenu();

	}

	private static void programmeTrainerMappingMenu() {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		char continueStatus = 0;

		do {
			System.out.println("*********************MENU**********************");
			System.out.println("   1.Display All     4.Get ProgrammTrainerMapping  ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				displayAllProgrammeTrainerMapping();
				break;
			case 4:
				getProgrammTrainerMapping();
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

	private static void getProgrammTrainerMapping() {
		// TODO Auto-generated method stub
		ProgrammeTrainerMappingServiceImpl programmeTrainerMappingServiceImpl = new ProgrammeTrainerMappingServiceImpl();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Mapping id:");
		int mappingId = scanner.nextInt();

		ProgrammeTrainerMapping programmeTrainerMapping = programmeTrainerMappingServiceImpl
				.getProgrammeTrainerMapping(mappingId);
		

	}

	private static void displayAllProgrammeTrainerMapping() {
		// TODO Auto-generated method stub
		ProgrammeTrainerMappingServiceImpl programmeTrainerMappingServiceImpl = new ProgrammeTrainerMappingServiceImpl();

		List<ProgrammeTrainerMapping> programmeTrainerMappingList = programmeTrainerMappingServiceImpl.displayAllProgrammeTrainerMapping();
		
		System.out.println("Registration ID        Member ID     Programme ID     Trainer ID       Start Date      End Date");
		for (ProgrammeTrainerMapping programmeTrainerMapping : programmeTrainerMappingList) {
			System.out.println("          "+programmeTrainerMapping.getMappingId()+programmeTrainerMapping.getProgramme().getProgrammeId()+programmeTrainerMapping.getMember().getMemberId()+programmeTrainerMapping.getTrainer().getTrainerId());
		}

	}

}
