package com.kabank.mvc.dao;
import java.sql.*;
public class JDBCTest {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"//데이터 프로퍼티주소
									,"bitcamp","bitcamp");//아이디와 비밀번호 던지는거임
			Statement stmt = conn.createStatement();
			String sql = "SELECT COUNT (*) AS count FROM tab"; //전체 테이블수를 알려줘 대문자 카운트의전체 소문자 카운트(키값)에 넣어라
			ResultSet rs = stmt.executeQuery(sql);
			String count = "";
			while(rs.next()) {
				count = rs.getString("count");
			}
			System.out.println("테이블 수: " + count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
