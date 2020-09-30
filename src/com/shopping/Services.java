package com.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.dao.ConnectionFactory;

public class Services {
	
	
	public static int Login(String user, String pass) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT EXISTS(SELECT 1 FROM users WHERE user = ? AND password = ?)";
			PreparedStatement stmt =con.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, pass);
			if (stmt.execute()) {
				sql = "SELECT userID FROM users WHERE user = ?";
				stmt =con.prepareStatement(sql);
				stmt.setString(1, user);
				return stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public static Boolean UserExists(String name) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT EXISTS(SELECT 1 FROM users WHERE user = ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			int i = stmt.executeUpdate();
			if (i == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static Boolean EmailExists(String email) {
		Connection con = ConnectionFactory.getConnection();
		try {
			String sql = "SELECT EXISTS(SELECT 1 FROM users WHERE email = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			int i = stmt.executeUpdate();
			if (i == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static Boolean ValidPassword(String pass) {
		if (pass.length() < 6) {
			System.out.println("Password must be at least 6 characters long");
			return false;
		} else if (pass.length() >18) {
			System.out.println("Passwword cannot be more than 18 characters long");
			return false;
		}
		
		return true;
	}
}
