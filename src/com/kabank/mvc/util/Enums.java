package com.kabank.mvc.util;

public class Enums {
	public enum MemberColumn {
		//끝에 세미콜론(;) 찎으면 안된다.
		ID,PASS,NAME,SSN,PHONE,EMAIL,PROFILE,ADDR
	}
	public enum AttendColumn{
		ID,PASS,NAME,
	}
	public enum Table{
		MEMBER,ATTEND,ADMIM
	}
	public enum DDL{
		SELECT,INSERT,INTO,UPDATE,DELETE,FORM
	}
	public static String getMemberColumn(){
		String temp = "";
		MemberColumn[] memberColumn = MemberColumn.values(); 
				for(int i=0; i<memberColumn.length;i++) {
					if(i == memberColumn.length-1) {
						temp += memberColumn[i];
					}else {
						temp += memberColumn[i]+",";
					}
					
				}
		return temp;
	}
	public static String getBlanks(int count) {
		String blanks = "";
		for(int i=0; i<count; i++) {
			blanks +="'%s','%s','%s','%s','%s','%s','%s','%s'";
		}
		return blanks;
	}
}
