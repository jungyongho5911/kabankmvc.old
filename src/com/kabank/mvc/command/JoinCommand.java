package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.iterator.ParamsIterator;

public class JoinCommand implements IOrder {
	Map<?,?> map;
	HttpSession session;
	String go;
	public JoinCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
		go = request.getServletPath();
		session = request.getSession();
		
	}

	@Override
	public void execute() {
		switch(go) {
		case"/user.do":
			InitCommand.cmd.setData(String.valueOf(map.get("id"))+","+
					String.valueOf(map.get("pass"))+","+
					String.valueOf(map.get("name"))+","+
					String.valueOf(map.get("ssn"))+","+
					String.valueOf(map.get("phone"))+","+
					String.valueOf(map.get("email"))+","+
					String.valueOf(map.get("profile"))+","+
					String.valueOf(map.get("addr"))+" "
					);
			break;
		case"/kakao.do":
			InitCommand.cmd.setData(((MemberBean)session.getAttribute("user")).getId());
			break;
		}
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%"+InitCommand.cmd.getData());
	}
	
}
