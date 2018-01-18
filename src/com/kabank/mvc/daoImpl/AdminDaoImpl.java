package com.kabank.mvc.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.enums.DDLEnum;
public class AdminDaoImpl implements AdminDAO {
	public static AdminDAO getInstance() {
		return new AdminDaoImpl();
	}
	private AdminDaoImpl() {
	}
	@Override
	public List<String> creatTables(String tname) {
		System.out.println("########### tname" + tname);
			List<String> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bitcamp","bitcamp");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tab");
			while(rs.next()) {
				String temp = rs.getString("TNAME");
				list.add(temp);
			}
			boolean flag = true;
			for(int i=0; i<list.size();i++) {
				if(list.get(i).equalsIgnoreCase(tname)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
				if(tname.equalsIgnoreCase("member")) {
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_MEMBER.toString());
				}else if(tname.equalsIgnoreCase("attend")) {
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_ATTEND.toString());	
				}else if(tname.equalsIgnoreCase("bank")) {
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_BANK.toString());
				}else if(tname.equalsIgnoreCase("phone")) {
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_SKT.toString());
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		
		return list;
		
	}

	
}
