package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.enums.PathEnum;
import com.kabank.mvc.service.AdminService;
import com.kabank.mvc.serviceImpl.AdminServiceImpl;

@WebServlet({"/admin/main.do","/admin/create_table.do","/admin/list.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("==============어드민 서블릿 들어옴===============");
		String dir = request.getServletPath().split(PathEnum.SEPARATOR.toString())[1];
		String dest = request.getServletPath().split(PathEnum.SEPARATOR.toString())[2].split(PathEnum.DOT.toString())[0];
		switch(dest) {
		case "main" :
			dest = "main";
			break;
		case "create_table":
			dest = "main";
			AdminService service = new AdminServiceImpl();
			service.createTable(request.getParameter("table_name"));
			break;
		case "list" :
			dest = "member_list";
		}
		System.out.println("======서블릿내부로들어옴");
		request.getRequestDispatcher(PathEnum.VIEW+dir+PathEnum.SEPARATOR+dest+PathEnum.EXTENSION)
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
