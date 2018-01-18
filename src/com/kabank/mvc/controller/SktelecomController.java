package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.JoinCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.serviceImpl.PhoneServieImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/phone.do"})
public class SktelecomController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		new InitCommand(request).execute();
	switch(InitCommand.cmd.getAction()) {
	case PHONE_MAIN :
		System.out.println("phone 메인 들어옴");
		new MoveCommand(request).execute();
		DispatcherServlet.send(request, response); 
		System.out.println("phone 메인 나감");
		break;
	case CREATE_PHONE_NUM:
		System.out.println("CREATE_PHONE_NUM 메인 들어옴");
		new JoinCommand(request).execute();
		PhoneServieImpl.getInstance().createNum();
		new MoveCommand(request).execute();
		DispatcherServlet.send(request, response);
		System.out.println("CREATE_PHONE_NUM 메인 나감");
	default:
		break;
	
	}	
	}


}
