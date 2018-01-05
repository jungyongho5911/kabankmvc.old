package com.kaban.mvc.daoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kabank.mvc.constant.CommonSQL;
import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.CommonDAO;
public class CommonDaoImpl implements CommonDAO {
	@Override
	public String selectTableCount() {
		String count = "";
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECTION_URL,DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD);
			Statement stmt =  conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(CommonSQL.getCount("tab"));
			while(rs.next()) {
				count = rs.getString("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return count;
	}
}
