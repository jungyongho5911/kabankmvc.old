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
import com.kabank.mvc.serviceImpl.KakaoServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;


@WebServlet({"/kakao.do"})
public class KakaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int i;
	public KakaoController() {
		i=10000;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("카카오 컨트롤러 들어옴");
		InitCommand init = new InitCommand(request);
		init.execute();
		switch(InitCommand.cmd.getAction()) {
		case KAKAO_MAIN:
			System.out.println("=============카카오 메인 들어옴===========");
			new MoveCommand(request).execute();
			System.out.println("=============카카오 메인 나감===========");
			DispatcherServlet.send(request, response); break;
		case ACCOUNT :
			System.out.println("카카오 컨트롤러 ACCOUNT 으로 들어옴");
			new JoinCommand(request).execute();
			KakaoServiceImpl.getInstance().accountNumber(i++);
			new MoveCommand(request).execute();
			DispatcherServlet.send(request, response); 
			System.out.println("카카오 컨트롤러 ACCOUNT 으로 나감");
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
