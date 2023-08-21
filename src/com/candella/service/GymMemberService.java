package com.candella.service;

import java.util.List;

import com.candella.entity.GymMember;

public interface GymMemberService {
	
	public void addMembers(GymMember gymMember);
	
	public void updateMembers(int memberId,String columName,String newValue );
	
	public GymMember getMember(int memberId);
	
	public List<GymMember> displayAllMember();}
