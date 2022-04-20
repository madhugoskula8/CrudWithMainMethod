package com.app.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url="jdbc:mysql://localhost:3306/test";
		String un="root";
		String pwd="admin";
		String sql="insert into emp value (?,?,?)";
		int count;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,un,pwd);
		PreparedStatement pst=con.prepareStatement(sql);
		
		//Reading from Keyboard
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter employee id : ");
		int id=scn.nextInt();
		
		System.out.println("Enter employee name");
		String name=scn.next();
		
		System.out.println("Enter employee salary : ");
		int sal=scn.nextInt();
		
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, sal);
		count=pst.executeUpdate();
		if(count>0)System.out.println("One row inserted");
		if(con!=null)con.close();
	}

}
