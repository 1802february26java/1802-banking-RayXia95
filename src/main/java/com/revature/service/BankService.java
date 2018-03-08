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

    public User getUserFromDB(String username, String password) {
	/**
	 * SQL to get user
	 */
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
	logger.info("Getting balance");
	return user.getBalance();
    }

    public void deposit(User user, double amount) {
	try {
	    if (amount > 0) {
		user.setBalance(user.getBalance() + amount);
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
		user.setBalance(user.getBalance() - widthdraw);
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
