package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.User;

public class UserDAOImpl implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
    private Connection connection = null;
    private PreparedStatement stmt = null;

    @Override
    public List<User> getAllUser() {
	List<User> users = new ArrayList<>();

	try {
	    connection = DAOUtilities.getConnection();
	    String sql = "SELECT * FROM USER_DB";
	    stmt = connection.prepareStatement(sql);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		User user = new User();

		user.setUsername(rs.getString("U_USERNAME)"));
		user.setPassword(rs.getString("U_PASSWORD"));
		user.setName(rs.getString("U_NAME"));
		user.setBalance(rs.getDouble("U_BALANCE"));

		users.add(user);
	    }

	    rs.close();

	}
	catch (SQLException e) {
	    logger.error("Could not get all users", e);
	}
	finally {
	    logger.info("Resources Closed");
	    closeResources();
	}
	logger.info("Got all my Users");
	return users;
    }

    @Override
    public User getUserByUsername(String username) {
	User user = null;
	try {
	    connection = DAOUtilities.getConnection();
	    String sql = "SELECT * FROM USER_DB WHERE U_USERNAME = ?";
	    stmt = connection.prepareStatement(sql);

	    stmt.setString(1, username);

	    ResultSet rs = stmt.executeQuery();

	    if (rs.next()) {
		user = new User();
		user.setUsername(rs.getString("U_USERNAME)"));
		user.setPassword(rs.getString("U_PASSWORD"));
		user.setName(rs.getString("U_NAME"));
		user.setBalance(rs.getDouble("U_BALANCE"));
	    }

	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
	finally {
	    closeResources();
	}

	return user;
    }

    @Override
    public boolean registerUser(String username, String password, String name, double balance) {
	try {
	    connection = DAOUtilities.getConnection();
	    String sql = "INSERT INTO USER_DB VALUES(?,?,?,?)";
	    stmt = connection.prepareStatement(sql);
	    int parameterIndex = 0;

	    stmt.setString(++parameterIndex, username);
	    stmt.setString(++parameterIndex, password);
	    stmt.setString(++parameterIndex, name);
	    stmt.setDouble(parameterIndex, balance);

	    if (stmt.executeUpdate() != 0) {
		return true;
	    }
	    else {
		return false;
	    }

	}
	catch (SQLException e) {
	    logger.error("Could not register user", e);
	}
	finally {
	    closeResources();
	}
	return false;
    }

    @Override
    public boolean deleteUser(String username) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean updateUserBalance(String username, double balance) {
	// TODO Auto-generated method stub
	return false;
    }

    private void closeResources() {
	try {
	    if (stmt != null) {
		stmt.close();
	    }
	}
	catch (SQLException e) {
	    System.out.println("Could not close statement!");
	    e.printStackTrace();
	}

	try {
	    if (connection != null) {
		connection.close();
	    }
	}
	catch (SQLException e) {
	    System.out.println("Could not close connection!");
	    e.printStackTrace();
	}
    }
}
