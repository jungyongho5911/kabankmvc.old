package com.kabank.mvc.enums;

public enum PathEnum {
	VIEW{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return"/WEB-INF/view/";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ".jsp";
		}
	},
	DOT{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "\\.";
		}
	}
	
	
}
