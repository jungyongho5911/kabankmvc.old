package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.iterator.ParamsIterator;

public class InitCommand implements IOrder {
	public static Command cmd ;
	Map<?,?>map;
	public InitCommand(HttpServletRequest request) {
		cmd = new Command();
		System.out.println("InitCommand cmd : " + cmd );
		map = ParamsIterator.excute(request);
		System.out.println("InitCommand map : " + map );
	}
	
	@Override
	public void execute() {	
		String o = String.valueOf(map.get("cmd"));
		System.out.println("InitCommand o : " + o );
		if(o.equals("null")) {
			cmd.setAction(ActionFactory.create("move"));
		}
		cmd.setAction(ActionFactory.create(o));
		System.out.println("InitCommand cmd : " + cmd.getAction());
		System.out.println("InitCommand cmd : " + cmd.getData());
	}
}
	
