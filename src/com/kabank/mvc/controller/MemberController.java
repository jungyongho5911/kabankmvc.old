package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.PathEnum;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceImpl.MemberServiceImpl;

@WebServlet({ "/user/login.do", "/user/join.do", "/user/auth.do","/user/signup.do" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberBean member = new MemberBean();
		MemberBean param = new MemberBean();
		MemberService memberService = MemberServiceImpl.getInstance();
		System.out.println("==============멤버 서블릿 들어옴===============");
		String dir = request.getServletPath().split(PathEnum.SEPARATOR.toString())[1];
		String action = request.getServletPath().split(PathEnum.SEPARATOR.toString())[2].split(PathEnum.DOT.toString())[0];
		String dest = "";
		HttpSession session = request.getSession();
		switch (action) {
		case "auth":
			param.setId(request.getParameter("index_input_id"));
			param.setPass(request.getParameter("index_input_pass"));
			
			member = memberService.findMemberById(param);
			System.out.println("%%%%%%%%%%%%%%%");
			if (member!=null) {
				dir = "bitcamp";
				dest = "main";
				session.setAttribute("user", member);
			} else {
				dir = "user";
				dest = "login";
			}
			break;
		case "login":
			dest = action;
			
			break;
		case "join":
		
			dest = action;
			break;
		case "signup":
			System.out.println("++++++사인업 들어옴");
			param.setId(request.getParameter(MemberEnum.ID.toString()));
			param.setPass(request.getParameter(MemberEnum.PASS.toString()));
			param.setName(request.getParameter(MemberEnum.NAME.toString()));
			param.setEmail(request.getParameter(MemberEnum.EMAIL.toString()));
			param.setSsn(request.getParameter(MemberEnum.SSN.toString()));
			param.setPhone(request.getParameter(MemberEnum.PHONE.toString()));
			param.setAddr(request.getParameter(MemberEnum.ADDR.toString()));
			param.setProfile(request.getParameter(MemberEnum.PROFILE.toString()));
			memberService.join(param);
			System.out.println("++++" + param.getId());
			System.out.println("++++" + param.getPass());
			dir = "user";
			dest = "login";
			break;
		default:
			break;
		}
		request.getRequestDispatcher(PathEnum.VIEW + dir + PathEnum.SEPARATOR + dest + PathEnum.EXTENSION).forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
