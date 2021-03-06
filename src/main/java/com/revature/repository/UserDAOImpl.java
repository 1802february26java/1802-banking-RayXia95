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

    private static UserDAOImpl userDAO = new UserDAOImpl();

    private UserDAOImpl() {
    }

    public static UserDAOImpl getUserDAO() {
	return userDAO;
    }

    @Override
    public List<User> getAllUser() {
	List<User> users = new ArrayList<>();

	try (Connection connection = DAOUtilities.getConnection()) {
	    logger.trace("Got my connection");
	    String sql = "SELECT * FROM USER_DB";
	    PreparedStatement stmt = connection.prepareStatement(sql);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		User user = new User();

		user.setUsername(rs.getString("U_USERNAME"));
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

	logger.info("Got all my Users");
	return users;
    }

    @Override
    public User getUserByUsername(String username) {
	try (Connection connection = DAOUtilities.getConnection()) {

	    logger.info("Got my connection");

	    String sql = "SELECT * FROM USER_DB WHERE U_USERNAME = ?";
	    PreparedStatement stmt = connection.prepareStatement(sql);

	    stmt.setString(1, username);

	    ResultSet rs = stmt.executeQuery();

	    if (rs.next()) {
		User user = new User();
		user.setUsername(rs.getString("U_USERNAME"));
		user.setPassword(rs.getString("U_PASSWORD"));
		user.setName(rs.getString("U_NAME"));
		user.setBalance(rs.getDouble("U_BALANCE"));
		logger.info("Got my user by username");
		return user;
	    }
	    rs.close();

	}
	catch (SQLException e) {
	    logger.error("Could not get user by username");
	}

	return null;
    }

    @Override
    public boolean registerUser(String username, String password, String name, double balance) {
	try (Connection connection = DAOUtilities.getConnection()) {
	    connection.setAutoCommit(false);
	    logger.info("Got my connection");

	    String sql = "INSERT INTO USER_DB VALUES(?,?,?,?)";
	    PreparedStatement stmt = connection.prepareStatement(sql);

	    int parameterIndex = 0;

	    stmt.setString(++parameterIndex, username);
	    stmt.setString(++parameterIndex, password);
	    stmt.setString(++parameterIndex, name);
	    stmt.setDouble(++parameterIndex, balance);

	    if (stmt.executeUpdate() != 0) {
		logger.info("Was able to register user");
		connection.commit();
		connection.setAutoCommit(true);
		return true;
	    }
	    else {
		return false;
	    }

	}
	catch (SQLException e) {
	    logger.error("Could not register user, username existed", e);
	}
	return false;
    }

    @Override
    public boolean deleteUser(String username) {
	try (Connection connection = DAOUtilities.getConnection()) {
	    logger.info("Got my connection");
	    String sql = "DELETE FROM USER_DB WHERE U_USERNAME = ?";
	    PreparedStatement stmt = connection.prepareStatement(sql);

	    stmt.setString(1, username);

	    if (stmt.executeUpdate() != 0) {
		logger.info("Was able to delete user");
		return true;
	    }
	    else {
		return false;
	    }
	}
	catch (SQLException e) {
	    logger.error("Could not delete user", e);
	}
	return false;
    }

    @Override
    public boolean updateUserBalance(String username, double balance) {

	try (Connection connection = DAOUtilities.getConnection()) {
	    String sql = "UPDATE USER_DB SET U_BALANCE = ? WHERE U_USERNAME = ?";
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    int parameterIndex = 0;

	    stmt.setDouble(++parameterIndex, balance);
	    stmt.setString(++parameterIndex, username);

	    if (stmt.executeUpdate() != 0) {
		logger.info("Was able to update balance");
		return true;
	    }
	    else {
		return false;
	    }
	}
	catch (SQLException e) {
	    logger.error("Could not update balance", e);
	}
	return false;
    }
}
