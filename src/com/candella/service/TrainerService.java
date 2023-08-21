package com.candella.service;

import java.util.List;

import com.candella.entity.Trainer;

public interface TrainerService {
	
public void addTrainer(Trainer trainer);
	
	public Trainer getTrainer(int trainerId);
	
	public void updateTrainer(int trainerId, String columnName, String newName);
	
	public List<Trainer> displayAllTrainer();
	
	
	

}
