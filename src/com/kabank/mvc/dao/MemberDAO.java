package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMembers();
	public void joinMembers();
	public MemberBean selectMemberById(MemberBean member);
	public MemberBean login();
	public void updatePass(MemberBean member);
	public void leaveMember();
	
}
