package com.app.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpSelect {

	public static void main(String[] args) throws Exception {

		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test";
		String un="root";
		String pwd="admin";
		String sql="select * from emp";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url);
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3));
		}con.close();
	}

}
