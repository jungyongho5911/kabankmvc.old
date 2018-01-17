package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.dao.KakaoDAO;
import com.kabank.mvc.service.AccountService;

public class AccountServiceImpl implements AccountService {
	KakaoDAO dao;
	public static AccountServiceImpl getInstance() {
		return new AccountServiceImpl();
	}
	private AccountServiceImpl() {
		
	}
	
}
