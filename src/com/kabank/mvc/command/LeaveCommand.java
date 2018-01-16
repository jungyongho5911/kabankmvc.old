package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.iterator.ParamsIterator;

public class LeaveCommand {
	Map<?,?> map;
	HttpSession session;
	public LeaveCommand (HttpServletRequest request) {
		map = ParamsIterator.excute(request);
		session = request.getSession();
	}
	public void execute() {
		InitCommand.cmd.setData(((MemberBean)session.getAttribute("user")).getId());
	}
}


