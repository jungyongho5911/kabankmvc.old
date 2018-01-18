package com.kabank.mvc.query.account;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;

public class InsertKakaoQuery implements IQuery {
	PreparedStatement pstmt;
public InsertKakaoQuery() {
	try {
		pstmt = DataBaseFactory.create(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(
				DML.INSERT
				+" "
				+DML.INSERT
				+" "
				+TnameEnum.BANK
				+"("
				+PropertiesFactory.create(AccountProps.values())
				+") "
				+DML.values()
				+"(custom_num.nextval,?,'0',?)");
		String[] arr = InitCommand.cmd.getData().split("/");
		for(int i=0; i<arr.length;i++) {
			pstmt.setString((i+1), arr[i]);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}
@Override
public Object execute() {
	// TODO Auto-generated method stub
	return null;
}
}
