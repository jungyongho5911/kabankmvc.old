package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.ChangeCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.JoinCommand;
import com.kabank.mvc.command.LeaveCommand;
import com.kabank.mvc.command.LoginCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceImpl.KakaoServiceImpl;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherServlet;

@WebServlet({"/user.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("체인지 패스에서 넘어온 cmd값은: "+request.getParameter("cmd"));
		MemberBean member = new MemberBean();
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
				System.out.println("==========로그인 성공==========");
				InitCommand.cmd.setData(member.getId());
				MemberBean memberwithAccount = KakaoServiceImpl.getInstance().findAccount(member.getId());
				if(memberwithAccount==null) {
					System.out.println("계좌거없는 맴버");
					session.setAttribute("user", member);
				}else {
					System.out.println("계좌거있는 맴버");
					session.setAttribute("user", memberwithAccount);
				}
				InitCommand.cmd.setDir("bitcamp");
				InitCommand.cmd.setPage("main");
			}
			new MoveCommand(request).execute();
			System.out.println("==============MEMBER : LOGIN OUT===========");
			DispatcherServlet.send(request, response); break;
		case CHANGE_PASS:
			System.out.println("==============MEMBER-C : CHANGE IN===========");
			member = new MemberBean();
			new ChangeCommand(request).execute();
			System.out.println("변경할 비밀번호는??:"+InitCommand.cmd.getData());
			member.setId(((MemberBean) session.getAttribute("user")).getId());
			member.setPass(InitCommand.cmd.getData());
			MemberServiceImpl.getInstance().changePass(member);
			member=(MemberBean) session.getAttribute("user");
			session.setAttribute("user", member);
			System.out.println("변경확인");
			System.out.println(member.toString());
			new MoveCommand(request).execute();
			System.out.println("DEST IS"+ InitCommand.cmd.getView());
			System.out.println("==============MEMBER-C : CHANGE OUT===========");
			DispatcherServlet.send(request, response);
			break;
		case LEAVE:
			System.out.println("==============MEMBER-C : LEAVE IN===========");	
			new LeaveCommand(request).execute();
			MemberServiceImpl.getInstance().leaveMember();
			session.invalidate();
			new MoveCommand(request).execute();
			DispatcherServlet.send(request, response);
			System.out.println("==============MEMBER-C : LEAVE OUT===========");	
			break;
		case JOIN:
			System.out.println("==============MEMBER-C : JOIN IN===========");
			new JoinCommand(request).execute();
			MemberServiceImpl.getInstance().joinMember();
			new MoveCommand(request).execute();
			DispatcherServlet.send(request, response);
			System.out.println("==============MEMBER-C : JOIN OUT===========");
		default:
			break;
		}
		
	}

	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}


}
