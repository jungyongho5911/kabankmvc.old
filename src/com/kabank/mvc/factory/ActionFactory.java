package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		Action action = null;
		if(x==null||x.equals("")==true) {x="move";}
		switch (x) {
		case "move":
			action = Action.MOVE;break;
		case "login":
			action = Action.LOGIN;break;
		default:
			action = Action.MOVE;break;
		}
		System.out.println(action);
		return action;
	}
}
