package com.candella.dao;

import java.util.List;

import com.candella.entity.Trainer;

public interface TrainerDAO {
	public void addTrainer(Trainer trainer);
	
	public Trainer getTrainer(int trainerId);
	
	public void updateTrainer(int trainerId, String columnName, String newName);
	
	public List<Trainer> displayAllTrainer();

}
