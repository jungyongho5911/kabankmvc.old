package com.kaban.mvc.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.enums.DDLEnum;
import com.kabank.mvc.enums.OracleEnum;
public class AdminDaoImpl implements AdminDAO {
	@Override
	public List<String> creatTable(String tname) {
			List<String> list = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(OracleEnum.ORACLE_CONNECTION_URL.toString(),OracleEnum.ORACLE_USERNAME.toString(),OracleEnum.ORACLE_PASSWORD.toString());
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
				if(tname.equalsIgnoreCase("member")) {
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_MEMBER.toString());
				}else if(tname.equalsIgnoreCase("attend")) {
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_ATTEND.toString());	
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		
		return list;
		
	}
}
