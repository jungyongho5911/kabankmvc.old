package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.MemberDaoImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao;
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {
		
	}
	@Override
	public MemberBean findMemberById(MemberBean member) {
			return MemberDaoImpl.getInstance().selectMemberById(member);
		}
	public void joinMember() {
		MemberDaoImpl.getInstance().joinMembers();
	}
	@Override
	public MemberBean login() {
		return MemberDaoImpl.getInstance().login();
	}
	public void changePass(MemberBean member) {
		MemberDaoImpl.getInstance().updatePass(member);
	}
	public void leaveMember() {
		MemberDaoImpl.getInstance().leaveMember();
		
	}
}

