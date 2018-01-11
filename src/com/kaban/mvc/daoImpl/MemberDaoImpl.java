package com.kaban.mvc.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.util.Enums;

public class MemberDaoImpl implements MemberDAO {
	ResultSet rs;
	
	public static MemberDAO getInstance() {return new MemberDaoImpl();}
	private MemberDaoImpl() {}
	@Override
	public List<MemberBean> selectMembers() {
		StringBuffer buff= new StringBuffer(DMLEnum.SELECT.toString());
		buff.insert(6,"").append(MemberEnum.ID+","+MemberEnum.PASS+" "+TnameEnum.MEMBER);
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			rs =DataBaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.createStatement().executeQuery(buff.toString());
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
		buff.insert(0, "").append(DMLEnum.INSERT.toString()+TnameEnum.MEMBER+" ( " 
				+ Enums.getMemberColumn() 
				+ " )VALUES( " +Enums.getBlanks(1)+" )");
		try {
			DataBaseFactory.createDatabase(Vendor.ORACLE)
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
		StringBuffer buff= new StringBuffer(DMLEnum.SELECT.toString());
		MemberBean mem = null;
		buff.insert(6," *").append(TnameEnum.MEMBER+" WHERE "+MemberEnum.ID+" = "+"'%s'"+" AND "+MemberEnum.PASS+" = "+"'%s'");
		try {
					rs = DataBaseFactory.createDatabase(Vendor.ORACLE)
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
			System.out.println("%%%%%%%%%%%%" + mem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}

}
