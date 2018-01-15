package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/user.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBean member = new MemberBean();
		MemberService memberService = MemberServiceImpl.getInstance();
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.execute();
		switch (InitCommand.cmd.getAction()) {
		case MOVE:
			System.out.println("==============MEMBER-C : MOVE IN===========");
			move(request);
			System.out.println("DEST IS"+ InitCommand.cmd.getView());
			System.out.println("==============MEMBER-C : MOVE OUT===========");
			DispatcherServlet.send(request, response);
			break;
		case LOGIN:
			System.out.println("==============MEMBER-C : LOGIN IN===========");
			new LoginCommand(request).execute();
			member = MemberServiceImpl.getInstance().login();
			if (member==null) {
				InitCommand.cmd.setDir("user");
				InitCommand.cmd.setPage("login");
				
			}else {
				session.setAttribute("user", member);
				InitCommand.cmd.setDir("bitcamp");
				InitCommand.cmd.setPage("main");
			}
			new MoveCommand(request).execute();
			System.out.println("==============MEMBER : LOGIN OUT===========");
			DispatcherServlet.send(request, response); break;
		case ADD:
			System.out.println("==============MEMBER : ADD IN===========");
			member.setId(request.getParameter(MemberEnum.ID.toString()));
			member.setPass(request.getParameter(MemberEnum.PASS.toString()));
			member.setName(request.getParameter(MemberEnum.NAME.toString()));
			member.setEmail(request.getParameter(MemberEnum.EMAIL.toString()));
			member.setSsn(request.getParameter(MemberEnum.SSN.toString()));
			member.setPhone(request.getParameter(MemberEnum.PHONE.toString()));
			member.setAddr(request.getParameter(MemberEnum.ADDR.toString()));
			member.setProfile(request.getParameter(MemberEnum.PROFILE.toString()));
			memberService.join(member);
			System.out.println("==============MEMBER : ADD OUT===========");
			break;
		default:
			break;
		}
		
	}

	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
