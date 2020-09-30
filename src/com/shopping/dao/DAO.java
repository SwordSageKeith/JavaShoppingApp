package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.model.*;

public class DAO {
	Connection con = ConnectionFactory.getConnection();
	
	
	
	
	
	public void MakeItem(Item item) {
		try {
			String sql = "INSERT INTO items (name, code, price) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getItemName());
			stmt.setString(2, item.getItemCode());
			stmt.setDouble(3, item.getPrice());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void MakeInvoice(Invoice inv) {
		try {
			String sql = "INSERT INTO invoices (customer, date, items)"; //im not sure if you can put an array into a database
			PreparedStatement stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void MakeUser(User user) {
		try {
			String sql = "";
			PreparedStatement stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
