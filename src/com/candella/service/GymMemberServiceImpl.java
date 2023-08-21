package com.candella.service;

import java.util.List;

import com.candella.dao.GymMemberDAOImpl;
import com.candella.entity.GymMember;

public class GymMemberServiceImpl implements GymMemberService{
	GymMemberDAOImpl gymMemberDAOImpl = new GymMemberDAOImpl();
	@Override
	public  void addMembers(GymMember gymMember) {
		gymMemberDAOImpl.addMembers(gymMember);
}
	@Override
	public void updateMembers(int memberId, String columName, String newValue) {
		// TODO Auto-generated method stub
		gymMemberDAOImpl.updateMembers(memberId,columName,newValue);
	}
	@Override
	public GymMember getMember(int memberId) {
		// TODO Auto-generated method stub
		return gymMemberDAOImpl.getMember(memberId);
		
	}
	@Override
	public List<GymMember> displayAllMember() {
		// TODO Auto-generated method stub
		return gymMemberDAOImpl.displayAllMember();
	}
}