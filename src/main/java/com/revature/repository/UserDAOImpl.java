package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;

public class UserDAOImpl implements UserDAO {

    Connection connection = null; // Our connection to the database
    PreparedStatement stmt = null; // We use prepared statements to help protect against SQL injection

    @Override
    public List<User> getAllUser() {
	List<User> users = new ArrayList<>();

	try {
	    connection = DAOUtilities.getConnection(); // Get our database connection from the manager
	    String sql = "SELECT * FROM Users"; // Our SQL query
	    stmt = connection.prepareStatement(sql); // Creates the prepared statement from the query

	    ResultSet rs = stmt.executeQuery(); // Queries the database

	    // So long as the ResultSet actually contains results...
	    while (rs.next()) {
		// We need to populate a Book object with info for each row from our query result
		User user = new User();

		// Each variable in our Book object maps to a column in a row from our results.
		user.setUsername(rs.getString("U_USERNAME)"));
		user.setPassword(rs.getString("U_PASSWORD"));
		user.setName(rs.getString("U_NAME"));
		user.setBalance(rs.getDouble("U_BALANCE"));
		// Finally we add it to the list of Book objects returned by this query.
		users.add(user);
	    }

	    rs.close();

	}
	catch (SQLException e) {
	    e.printStackTrace();
	}
	finally {
	    closeResources();
	}
	return users;
    }

    @Override
    public User getUserByUsername(String username) {
	User user = null;

	try {
	    connection = DAOUtilities.getConnection();
	    String sql = "SELECT * FROM User WHERE U_USERNAME = ?";
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
    public boolean registerUser(String username, String password, String name, int balance) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean deleteUser(String username) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean updateUserBalance(String username, int balance) {
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
