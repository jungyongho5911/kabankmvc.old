package com.kabank.mvc.enums;

public enum TnameEnum {
	MEMBER, ATTEND,BANK,
	TNAMES{
@Override
		public String toString() {
			return MEMBER+","+ATTEND;
		}
	}, 
}
