package com.kabank.mvc.daoImpl;


import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.KakaoDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class KakaoDaoImpl implements KakaoDAO {
	public static KakaoDaoImpl getInstance() {
		return new KakaoDaoImpl();
	}
	private KakaoDaoImpl() {
		
	}
	public void accountNumbers(int i) {
		System.out.println("accountNumbers 진입 성공");
		StringBuffer sql = new StringBuffer( DMLEnum.ACCOUNT_NUMBER.toString());
		String foo = InitCommand.cmd.getData();
		System.out.println("accountNumbers foo = "+foo);
		String res = String.valueOf(String.format("%04d", (int) (Math.random()*10000)))+"-"+
				String.valueOf(String.format("%04d", (int) (Math.random()*10000)))+"-"+
				String.valueOf(String.format("%04d", (int) (Math.random()*10000)));
		try {
		DataBaseFactory.create(Vendor.ORACLE)
		.getConnection()
		.createStatement()
		.executeQuery(String.format(sql.toString(),res,i,foo,"10000" ));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
