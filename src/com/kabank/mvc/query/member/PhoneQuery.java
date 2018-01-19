package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.PhoneBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.enums.PhoneProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class PhoneQuery implements IQuery {
	PreparedStatement pstmt;
	
	public PhoneQuery() {
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(
					DML.SELECT
					+" "
					+"m.id,"
					+"m.pass,"
					+"m.name,"
					+"m.ssn,"
					+"m.phone,"
					+"m.email,"
					+"m.profile,"
					+"m.addr,"
					+"a.customer_num,"
					+"a.account_num,"
					+"a.money,"
					+"p.phone_num,"
					+"p.regdate "
					+DML.FROM
					+" Member m, Bank a, Phone p "
					+DML.WHERE
					+" m.id = a.id AND m.id = p.id AND m.id LIKE ? "
					);
			pstmt.setString(1, InitCommand.cmd.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
@Override
public Object execute() {
	 MemberBean member = null;
	 AccountBean account = null;
	 PhoneBean phoneBean = null;
     try {
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
             member = new MemberBean();
             account = new AccountBean();
             phoneBean = new PhoneBean();
             member.setId(rs.getString(MemberProps.ID.toString()));
             member.setPass(rs.getString(MemberProps.PASS.toString()));
             member.setName(rs.getString(MemberProps.NAME.toString()));
             member.setEmail(rs.getString(MemberProps.EMAIL.toString()));
             member.setAddr(rs.getString(MemberProps.ADDR.toString()));
             member.setPhone(rs.getString(MemberProps.PHONE.toString()));
             member.setSsn(rs.getString(MemberProps.SSN.toString()));
             member.setProfile(rs.getString(MemberProps.PROFILE.toString()));
             account.setAccountnum(rs.getString(AccountProps.ACCOUNT_NUM.toString()));
             account.setCustomnum(rs.getString(AccountProps.CUSTOMER_NUM.toString()));
             account.setMoney(rs.getString(AccountProps.MONEY.toString()));
             phoneBean.setPhoneNumber(rs.getString(PhoneProps.PHONE_NUM.toString()));
             phoneBean.setRegdate(rs.getString(PhoneProps.REGDATE.toString()));
             member.setAccount(account);
             member.setPhoneBean(phoneBean);
             System.out.println("로그인쿼리에 들어있는 member" +member);
             System.out.println("로그인쿼리에 들어있는 member"+member.getAccount());
             System.out.println("로그인쿼리에 들어있는 member"+member.getPhoneBean());
         }
     }catch(Exception e) {
         e.printStackTrace();
     }
     return member;
}
}