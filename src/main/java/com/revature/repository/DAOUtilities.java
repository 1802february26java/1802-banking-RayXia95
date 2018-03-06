package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {

    private static final String CONNECTION_USERNAME = "BANK_MANAGER";
    private static final String CONNECTION_PASSWORD = "p4ssw0rd";
    private static final String URL = "myrevaturerds.cyjl3lot33bp.us-east-1.rds.amazonaws.com";
    private static Connection connection;

    public static synchronized Connection getConnection() throws SQLException {
	if (connection == null) {
	    try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    }
	    catch (ClassNotFoundException e) {
		System.out.println("Could not register driver!");
		e.printStackTrace();
	    }
	    connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
	}

	//If connection was closed then retrieve a new connection
	if (connection.isClosed()) {
	    System.out.println("Opening new connection...");
	    connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
	}
	return connection;
    }

}
