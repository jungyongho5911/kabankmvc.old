package com.kabank.mvc.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.SqlFcatory;
import com.kabank.mvc.util.Enums;

public class MemberDaoImpl implements MemberDAO {
	ResultSet rs;
	public static MemberDAO getInstance() {return new MemberDaoImpl();}
	private MemberDaoImpl() {}
	@Override
	public List<MemberBean> selectMembers() {
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			rs =DataBaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement().executeQuery(SqlFcatory.create(6," ", 
							MemberEnum.
							ID+DMLEnum.FULLSTOP.toString()
							+MemberEnum.PASS+" "+TnameEnum.MEMBER));
			while (rs.next()) {
				MemberBean member = new MemberBean();
				member.setId(rs.getString(MemberEnum.ID.toString()));
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void joinMembers(MemberBean member) {
		StringBuffer buff= new StringBuffer();
		buff.insert(0, "").append(DMLEnum.INSERT.toString()+TnameEnum.MEMBER+DMLEnum.PARENTHESES.toString() 
				+ Enums.getMemberColumn() 
				+ DMLEnum.VALUES.toString() +Enums.getBlanks(1)+DMLEnum.PARENTHESESCLOSE.toString());
		try {
			DataBaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeUpdate(String.format(buff.toString(),
							member.getId(), member.getPass(), member.getName(), member.getSsn(), member.getPhone(),
							member.getEmail(), member.getProfile(), member.getAddr()));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	@Override
	public MemberBean selectMemberById(MemberBean member) {
		System.out.println("=====================selectbyidin");
		System.out.println("id=========="+member.getId());
		System.out.println("pass=========="+member.getPass());
		StringBuffer buff= new StringBuffer(DMLEnum.SELECT.toString());
		MemberBean mem = null;
		buff.insert(6," *").append(TnameEnum.MEMBER
				+" "+DMLEnum.WHERE+" "+MemberEnum.ID+DMLEnum.EQUAL.toString()
		+DMLEnum.SPACE.toString()+" "+DMLEnum.AND+" "+MemberEnum.PASS+DMLEnum.EQUAL.toString()+DMLEnum.SPACE.toString());
		try {
					rs = DataBaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(String.format(buff.toString(),member.getId(),member.getPass()));
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					while (rs.next()) {
				System.out.println("%%%%%%%%%%%%%%들어온 rs.getString(1)=" + rs.getString(1));
				System.out.println("%%%%%%%%%%%%%%들어온 rs.getString(2)=" + rs.getString(2));
				mem = new MemberBean();
				mem.setId(rs.getString(MemberEnum.ID.toString()));
				mem.setPass(rs.getString(MemberEnum.PASS.toString()));
				mem.setName(rs.getString(MemberEnum.NAME.toString()));
				mem.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				mem.setAddr(rs.getString(MemberEnum.ADDR.toString()));
				mem.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				mem.setSsn(rs.getString(MemberEnum.SSN.toString()));
				mem.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
			}
			System.out.println("%%%%%%%%%%%" + mem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("id=========="+member.toString());
		System.out.println("=====================selectbyidout");
		return mem;
	}
	@Override
	public MemberBean login() {
		System.out.println("==============MEMBER-D : LOGIN IN===========");
		System.out.println("==============MEMBER-D :"+InitCommand.cmd.getData());
		StringBuffer sql = new StringBuffer(
				MemberEnum.LOGIN.toString());
		System.out.println("====================MEMBER-D sql ="+sql);
		String[] arr = InitCommand.cmd.getData().split("/");
		System.out.println("================MEMBER-D arr="+arr);
		System.out.println("ID :arr[0] "+arr[0]);
		System.out.println("PASS :arr[1] "+arr[1]);
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, arr[0]);
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, arr[1]);
		System.out.println(":::::::SQL:::::"+sql.toString());
		MemberBean member = null;
		try{
			ResultSet rs = DataBaseFactory.create(Vendor.ORACLE)
					.getConnection()
					.createStatement()
					.executeQuery(sql.toString());
			while(rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(MemberEnum.ID.toString()));
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				member.setName(rs.getString(MemberEnum.NAME.toString()));
				member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				member.setPass(rs.getString(MemberEnum.PASS.toString()));
				member.setSsn(rs.getString(MemberEnum.SSN.toString()));
				member.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("==============MEMBER-D : LOGIN OUT===========");
		return member;
	}

}
