package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DAOUtilities {

    private static final Logger logger = Logger.getLogger(DAOUtilities.class);

    public static synchronized Connection getConnection() throws SQLException {
	final String CONNECTION_USERNAME = "BANK_DB";
	final String CONNECTION_PASSWORD = "p4ssw0rd";
	final String URL = "jdbc:oracle:thin:@myrevaturerds.cyjl3lot33bp.us-east-1.rds.amazonaws.com:1521:ORCL";

	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	catch (ClassNotFoundException e) {
	    logger.error("Could not find my driver!", e);
	}

	return DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
    }

}
