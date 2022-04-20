package com.app.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpUpdate {

	public static void main(String[] args) throws SQLException {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test";
		String un="root";
		String pwd="admin";
		String sql="update emp set name=? where id=?";
		
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url,un,pwd);

			pst=con.prepareStatement(sql);
			pst.setString(1, "Ramesh");
			pst.setInt(2, 101);
			int count=pst.executeUpdate();
			if(count>0) {
				System.out.println("One row updated!...");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(con!=null) {
				con.close();
			}
		}

	}
}
