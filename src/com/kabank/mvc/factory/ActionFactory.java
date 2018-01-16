package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		System.out.println("ActionFactory========="+action);
		if(x==null||x.equals("")==true) {x="move";}
		switch (x) {
		case "move":
			action = Action.MOVE;break;
		case "login":
			action = Action.LOGIN;break;
		case "change_pass":
			action = Action.CHANGE_PASS;break;
		case "leave":	
			action = Action.LEAVE;break;
		case "join":
			action = Action.JOIN;break;	
		default:
			action = Action.MOVE;break;
		}
		System.out.println("######################"+action);
		return action;
	}
}
