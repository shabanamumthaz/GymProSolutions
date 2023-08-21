package com.candella.dao;

import java.util.List;

import com.candella.entity.GymMember;

public interface GymMemberDAO {
	
	public void addMembers(GymMember gymMember);
	public void updateMembers(int memberId,String columnName,String newValue);
	public GymMember getMember(int memberId);
	public List<GymMember> displayAllMember();
	
	

}
