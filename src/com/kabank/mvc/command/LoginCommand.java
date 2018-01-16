package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class LoginCommand implements IOrder {
	Map<?,?> map;
	public LoginCommand (HttpServletRequest request) {
		map = ParamsIterator.excute(request);
	}
	@Override
	public void execute() {
		System.out.println("==============LoginCommnad IN==============");
		String id = String.valueOf(map.get("index_input_id"));
		System.out.println("LoginCommand id = "+ id);
		String pass = String.valueOf(map.get("index_input_pass"));
		System.out.println("LoginCommand pass = "+ pass);
		InitCommand.cmd.setColumn("id/pass");
		System.out.println(InitCommand.cmd.getColumn());
		InitCommand.cmd.setData(id+"/"+pass);
		System.out.println(InitCommand.cmd.getData());
		System.out.println("==============LoginCommnad OUT==============");
		
	}
}
