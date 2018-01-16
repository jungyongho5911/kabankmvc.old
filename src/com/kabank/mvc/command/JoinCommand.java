package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class JoinCommand implements IOrder {
	Map<?,?> map;
	public JoinCommand(HttpServletRequest request) {
		map = ParamsIterator.excute(request);
	}

	@Override
	public void execute() {
		InitCommand.cmd.setData(String.valueOf(map.get("id"))+","+
				String.valueOf(map.get("pass"))+","+
				String.valueOf(map.get("name"))+","+
				String.valueOf(map.get("ssn"))+","+
				String.valueOf(map.get("phone"))+","+
				String.valueOf(map.get("email"))+","+
				String.valueOf(map.get("profile"))+","+
				String.valueOf(map.get("addr"))+" "
				);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%"+InitCommand.cmd.getData());
	}
	
}
