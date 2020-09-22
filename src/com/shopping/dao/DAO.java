package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.model.*;

public class DAO {
	Connection con = ConnectionFactory.getConnection();
	
	
	
	
	
	public void MakeItem(Item item) {
		try {
			String sql = "";
			PreparedStatement stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void MakeInvoice(Invoice inv) {
		try {
			String sql = "";
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
