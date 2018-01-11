package com.kabank.mvc.daoImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.OracleEnum;
import com.kabank.mvc.enums.TnameEnum;
public class CommonDaoImpl implements CommonDAO {
	@Override
	public String selectTableCount() {
		String count = "";
		try {
			Class.forName(OracleEnum.ORACLE_DRIVER.toString());
			Connection conn = DriverManager.getConnection(OracleEnum.ORACLE_CONNECTION_URL.toString(),OracleEnum.ORACLE_USERNAME.toString(),OracleEnum.ORACLE_PASSWORD.toString());
			Statement stmt =  conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(DMLEnum.COUNT.toString()+TnameEnum.MEMBER);
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
