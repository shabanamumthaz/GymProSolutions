package com.candella.entity;

public class ProgrammeTrainerMapping {
	
	private int mappingId;
	private Programme programme;
	private Trainer trainer;
	private GymMember member;
	public ProgrammeTrainerMapping(int mappingId, Programme programme, Trainer trainer, GymMember member) {
		super();
		this.mappingId = mappingId;
		this.programme = programme;
		this.trainer = trainer;
		this.member = member;
	}
	public int getMappingId() {
		return mappingId;
	}
	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
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
	public GymMember getMember() {
		return member;
	}
	public void setMember(GymMember member) {
		this.member = member;
	}
	
	

}
