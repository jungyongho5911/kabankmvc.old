package com.kabank.mvc.serviceImpl;

import com.kaban.mvc.daoImpl.MemberDaoImpl;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao;
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {
		  dao = MemberDaoImpl.getInstance();
	}
	@Override
	public MemberBean findMemberById(MemberBean member) {
			return dao.selectMemberById(member);
		}
	public void join(MemberBean member) {
		
		dao.joinMembers(member);
		System.out.println("================"+member);
		
	}
}

