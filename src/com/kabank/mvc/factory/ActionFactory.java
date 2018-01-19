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
		case "account":
			action = Action.ACCOUNT;break;
		case "kakao":
			action = Action.KAKAO_MAIN;break;
		case "phone":
			action = Action.PHONE_MAIN;break;
		case"phone_numbur":
			action = Action.CREATE_PHONE_NUM;break;
		case "logout":
			action = Action.LOGOUT;break;
		default:
			action = Action.MOVE;break;
		}
		System.out.println("######################"+action);
		return action;
	}
}
