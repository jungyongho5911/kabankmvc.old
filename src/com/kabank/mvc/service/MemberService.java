package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public abstract MemberBean findMemberById(MemberBean member);
	public abstract MemberBean login();
	public abstract void changePass(MemberBean member);
	public abstract void leaveMember();

}
