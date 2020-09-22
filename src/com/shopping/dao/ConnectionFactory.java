package com.shopping.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;


public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://root@localhost:3306/etsy";
    public static final String USER = "root";
    public static final String PASS = "password";

    public static java.sql.Connection getConnection() {
    	try {
    		DriverManager.registerDriver(new Driver());
    		return DriverManager.getConnection(URL, USER, PASS);
    	} catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
            
        }
    }
}
