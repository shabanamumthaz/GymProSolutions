package com.candella.entity;

import java.time.LocalDate;

public class Registration {
	private int regId;
	private GymMember gym_member;
	private Programme programme;
	private Trainer trainer;
	private LocalDate startDate;
	private LocalDate endDate;
	public Registration(int regId, GymMember gym_member, Programme programme, Trainer trainer, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.regId = regId;
		this.gym_member = gym_member;
		this.programme = programme;
		this.trainer = trainer;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public GymMember getGym_member() {
		return gym_member;
	}
	public void setGym_member(GymMember gym_member) {
		this.gym_member = gym_member;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

		
}
