package com.kaban.mvc.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.constant.MemberSQL;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
public class MemberDaoImpl implements MemberDAO {
	
	@Override
	public List<MemberBean> selectMembers() {
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL,DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(MemberSQL.MEMBERS);
			while(rs.next()) {
				MemberBean member = new MemberBean();
				member.setId(rs.getString("id"));
				member.setPass(rs.getString("pass"));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
