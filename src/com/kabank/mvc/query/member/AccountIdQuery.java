package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.AccountProps;
import com.kabank.mvc.enums.DML;
import com.kabank.mvc.enums.MemberProps;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class AccountIdQuery implements IQuery {
	 PreparedStatement pstmt;
	   AccountBean account = null;

public AccountIdQuery() {
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
                         +"a.customnum,"
                         +"a.accountnum,"
                         +"a.money "
                         +DML.FROM
                         +" Member m, Bank a "
                         +DML.WHERE
                         +" m.id = a.id and m.id LIKE ?");
         pstmt.setString(1, InitCommand.cmd.getData());
         
     } catch (SQLException e) {
         e.printStackTrace();
     }
}

public Object execute() {
	 MemberBean member = null;
     try {
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
             member = new MemberBean();
             account = new AccountBean();
             member.setId(rs.getString(MemberProps.ID.toString()));
             member.setPass(rs.getString(MemberProps.PASS.toString()));
             member.setName(rs.getString(MemberProps.NAME.toString()));
             member.setEmail(rs.getString(MemberProps.EMAIL.toString()));
             member.setAddr(rs.getString(MemberProps.ADDR.toString()));
             member.setPhone(rs.getString(MemberProps.PHONE.toString()));
             member.setSsn(rs.getString(MemberProps.SSN.toString()));
             member.setProfile(rs.getString(MemberProps.PROFILE.toString()));
             account.setCustomNum(rs.getString(AccountProps.CUSTOMNUM.toString()));
             account.setAccountNum(rs.getString(AccountProps.ACCOUNTNUM.toString()));
             account.setMoney(rs.getString(AccountProps.MONEY.toString()));
             member.setAccount(account);
         }
     }catch(Exception e) {
         e.printStackTrace();
     }
     return member;
 }
}
