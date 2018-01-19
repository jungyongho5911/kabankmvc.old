package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.PhoneDaoImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.PhoneService;

public class PhoneServieImpl implements PhoneService {
	public static PhoneService getInstance() {return new PhoneServieImpl();}
	private PhoneServieImpl() {
	}
	@Override
	public void createNum() {
		String result = ("010"+"-"+String.valueOf(String.format(
				"%04d", (int) (Math.random()*10000)))+"-"+
				String.valueOf(String.format(
				"%04d", (int) (Math.random()*10000))));
		PhoneDaoImpl.getInstance().createPhoneNum(result);
	}
	@Override
	public MemberBean findPhone(String id) {
		return PhoneDaoImpl.getInstance().selectById(id);
	}

}
