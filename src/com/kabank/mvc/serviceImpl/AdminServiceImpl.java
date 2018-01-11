package com.kabank.mvc.serviceImpl;

import com.kaban.mvc.daoImpl.AdminDaoImpl;
import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDAO admindao;
	public AdminServiceImpl() {
		admindao = new AdminDaoImpl();
	}
	@Override
	public void createTable(String tname) {
		admindao.creatTable(tname);
	}

	

}
