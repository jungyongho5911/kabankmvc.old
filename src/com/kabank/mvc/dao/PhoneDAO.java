package com.kabank.mvc.dao;

import com.kabank.mvc.domain.MemberBean;

public interface PhoneDAO {
	
	public void createPhoneNum(String result);

	public MemberBean selectById(String id);

}
