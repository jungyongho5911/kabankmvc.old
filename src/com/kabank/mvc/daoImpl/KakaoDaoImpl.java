package com.kabank.mvc.daoImpl;


import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.KakaoDAO;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.query.member.AccountIdQuery;

public class KakaoDaoImpl implements KakaoDAO {
	public static KakaoDAO getInstance() {
		return new KakaoDaoImpl();
	}
	private KakaoDaoImpl() {
		
	}
	public void accountNumbers(String account) {
		System.out.println("accountNumbers 진입 성공");
		StringBuffer sql = new StringBuffer( DMLEnum.ACCOUNT_NUMBER.toString());
		String foo = InitCommand.cmd.getData();
		System.out.println("accountNumbers foo = "+foo);
		try {
		DataBaseFactory.create(Vendor.ORACLE)
		.getConnection()
		.createStatement()
		.executeUpdate(String.format(sql.toString(),"custom_Num.nextval",account,"10000",foo));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	@Override
	public MemberBean selectByid(String id) {
		return (MemberBean) new ExecuteUpdate(new AccountIdQuery()).execute();
	}
}
