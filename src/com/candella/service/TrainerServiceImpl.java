package com.candella.service;


import java.util.List;

import com.candella.dao.TrainerDAOImpl;
import com.candella.entity.Trainer;

public class TrainerServiceImpl implements TrainerService{
	
	TrainerDAOImpl trainerDAOImpl=new TrainerDAOImpl();

	@Override
	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		
	 trainerDAOImpl.addTrainer(trainer);
	}

	@Override
	public Trainer getTrainer(int trainerId) {
		// TODO Auto-generated method stub
		
		return trainerDAOImpl.getTrainer(trainerId);
	}

	@Override
	public void updateTrainer(int trainerId, String columnName, String newName) {
		// TODO Auto-generated method stub
		trainerDAOImpl.updateTrainer(trainerId,columnName,newName);
		
	}

	@Override
	public List<Trainer> displayAllTrainer() {
		// TODO Auto-generated method stub
		return trainerDAOImpl.displayAllTrainer();
		
	}

	
}
