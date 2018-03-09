package com.revature.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.exception.DepositByZeroOrLessException;
import com.revature.exception.IllegalWidthdrawlException;
import com.revature.exception.InsufficientFundException;
import com.revature.model.User;
import com.revature.repository.UserDAOImpl;

public class BankService {

    private static final Logger logger = Logger.getLogger(BankService.class);

    public void registerUser(User user) {
	new UserDAOImpl().registerUser(user.getUsername(), user.getPassword(), user.getName(), user.getBalance());
    }

    public User getUserFromDB(String username, String password) {
	try {
	    User user = new UserDAOImpl().getUserByUsername(username);
	    if (user == null) {
		throw new SQLException();
	    }
	    else if (user.getPassword().equals(password)) {
		logger.info("Successfully gotten user from DB");
		return user;
	    }
	    else {
		throw new IllegalArgumentException();
	    }
	}
	catch (SQLException e) {
	    logger.error("Couldn't get user from database");
	}
	catch (IllegalArgumentException d) {
	    logger.error("Wrong password");
	}
	return null;
    }

    public double getBalance(User user) {
	logger.info("Got balance");
	return new UserDAOImpl().getUserByUsername(user.getUsername()).getBalance();
    }

    public void deposit(User user, double amount) {
	try {
	    if (amount > 0) {
		new UserDAOImpl().updateUserBalance(user.getUsername(), (getBalance(user) + amount));
		logger.info("Successfully added balance");
	    }
	    else {
		throw new DepositByZeroOrLessException("You have to have money to put money in");
	    }

	}
	catch (DepositByZeroOrLessException e) {
	    logger.error(e);
	}
    }

    public void widthdraw(User user, double widthdraw) {
	try {
	    if (widthdraw < 0) {
		throw new IllegalWidthdrawlException("Cannot widthdraw negative amount");
	    }
	    if (user.getBalance() >= widthdraw) {
		new UserDAOImpl().updateUserBalance(user.getUsername(), (getBalance(user) - widthdraw));
		logger.info("Successfully minus balance");
	    }
	    else {
		throw new InsufficientFundException("Too broke, you need more money in your account");
	    }
	}
	catch (IllegalWidthdrawlException e) {
	    logger.error(e);
	}
	catch (InsufficientFundException e) {
	    logger.error(e);
	}

    }

    public User logout(User user) {
	user = null;
	logger.info("User does not exist anymore and logged off");
	return user;
    }
}
