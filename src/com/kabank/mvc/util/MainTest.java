package com.kabank.mvc.util;

import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.TnameEnum;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MemberColumn c : 
				Enums.MemberColumn.values()) {
			System.out.println("컬럼명 : "+c);
		}
		StringBuffer buff = new StringBuffer(DMLEnum.SELECT.toString());
		buff.insert(6,"").append(MemberEnum.ID+DMLEnum.FULLSTOP.toString()+MemberEnum.PASS+" "+TnameEnum.MEMBER);
				System.out.println("기본버프 : " +buff);
				//"SELECT * FROM Member WHERE id = '%s' AND pass = '%s'"
			
	}
}
