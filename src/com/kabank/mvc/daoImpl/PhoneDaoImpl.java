package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.PhoneDAO;

public class PhoneDaoImpl implements PhoneDAO {
	public static PhoneDAO getInstance() {return new PhoneDaoImpl(); }
	private PhoneDaoImpl() {
	}
	@Override
	public void createPhoneNum() {
		System.out.println("createPhoneNumDAOIMPL 진입");
		
	}
}
