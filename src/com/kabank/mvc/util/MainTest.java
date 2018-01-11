package com.kabank.mvc.util;

import com.kabank.mvc.enums.DMLEnum;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MemberColumn c : 
				Enums.MemberColumn.values()) {
			System.out.println("컬럼명 : "+c);
		}
		StringBuffer buff = new StringBuffer(DMLEnum.SELECT.toString());
				System.out.println("기본버프 : " +buff);
				//"SELECT * FROM Member WHERE id = '%s' AND pass = '%s'"
			
	}
}
