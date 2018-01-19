package com.kabank.mvc.enums;

public enum Action {
	MOVE,ADD,LOGIN,JOIN,SEARCH,CHANGE_PASS,LEAVE,KAKAO_MAIN,ACCOUNT,
	PHONE_MAIN,CREATE_PHONE_NUM,LOGOUT,
	VIEW{
		@Override
		public String toString() {
			return "/WEB-INF/view/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			return ".jsp";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			return "/";
		}
	}
}
