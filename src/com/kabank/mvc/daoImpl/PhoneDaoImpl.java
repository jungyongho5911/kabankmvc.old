package com.kabank.mvc.daoImpl;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.PhoneDAO;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.query.member.PhoneQuery;


public class PhoneDaoImpl implements PhoneDAO {
	public static PhoneDAO getInstance() {return new PhoneDaoImpl(); }
	private PhoneDaoImpl() {
	}
	@Override
	public void createPhoneNum(String result) {
		System.out.println("createPhoneNumDAOIMPL 진입"+result);
		StringBuffer sql = new StringBuffer(DMLEnum.PHONE_NUMBER.toString());
		try {
			DataBaseFactory.create(Vendor.ORACLE)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(sql.toString(),result,InitCommand.cmd.getData()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public MemberBean selectById(String id) {
	return (MemberBean) new ExecuteUpdate(new PhoneQuery()).execute();
	}
}
