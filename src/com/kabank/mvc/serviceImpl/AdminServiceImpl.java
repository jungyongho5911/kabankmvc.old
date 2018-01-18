package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.AdminDaoImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService {
	public static AdminService getInstance() {return new AdminServiceImpl();}
	private AdminServiceImpl() {
	}
	@Override
	public void createTable(String tname) {
	AdminDaoImpl.getInstance().creatTables(tname);
	}
}
