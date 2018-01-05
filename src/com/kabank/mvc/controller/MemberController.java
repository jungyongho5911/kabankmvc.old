package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.constant.Path;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;

@WebServlet({"/user/login.do","/user/join.do","/user/auth.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("==============서블릿 내부로 들어옴===============");
		String dir = request.getServletPath().split(Path.SEPARATOR)[1];
		String action =request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		String dest = "";
		switch (action) {
		case "auth":
			MemberBean member = new MemberBean();
			member.setId(request.getParameter("index_input_id"));
			member.setPass(request.getParameter("index_input_pass"));
			MemberService memberService = new MemberServiceImpl();
			boolean flag = memberService.login(member);
			if(flag) {
				dir = "bitcamp";
				dest = "main";
			}else {
				dir = "user";
				dest = "login";
			}
			break;
		case "login":
			dest = action;
			break;
		case "join" :
			dest = action;
			break;
		default:
			break;
		}
		request
			.getRequestDispatcher(Path.VIEW+dir+Path.SEPARATOR+dest+Path.EXTENSION)
			.forward(request, response);
				
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
