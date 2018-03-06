package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.exception.DepositByZeroOrLessException;
import com.revature.exception.IllegalWidthdrawlException;
import com.revature.exception.InsufficientFundException;
import com.revature.exception.InvalidCredentials;
import com.revature.model.User;

public class BankService {

    private static final Logger logger = Logger.getLogger(BankService.class);

    public void authenicateUser(User user, String username, String password) {
	try {
	    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
		logger.info("Username and password is correct. User validated");
	    }
	    else {
		throw new InvalidCredentials("Username or password is incorrect");
	    }
	}
	catch (InvalidCredentials e) {
	    logger.error(e);
	}

    }

    public User getUserFromDB(String username, String password) {
	/**
	 * SQL to get user
	 */
	User user = new User();
	// String savedUsername = SELECT username FROM User WHERE username="username"
	// String savedPassword = SELECT password FROM User WHERE password="password"
	// String name = SELECT name FROM User WHERE username="username"
	// int balance = SELECT balance FROM User WHERE username="username"
	// myrevaturerds.cyjl3lot33bp.us-east-1.rds.amazonaws.com
	String savedUsername = "";
	String savedPassword = "";
	String name = "";
	int balance = 0;

	user.setName(name);
	user.setUsername(savedUsername);
	user.setPassword(savedPassword);
	user.setBalance(balance);
	logger.info("Successfully gotten user from DB");
	return user;
    }

    public int getBalance(User user) {
	logger.info("Getting balance");
	return user.getBalance();
    }

    public void deposit(User user, int amount) {
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

    public void widthdraw(User user, int widthdraw) {
	try {
	    if (widthdraw < 0) {
		throw new IllegalWidthdrawlException("Cannot widthdraw negative amount");
	    }
	    if (user.getBalance() >= widthdraw) {
		user.setBalance(user.getBalance() - widthdraw);
		logger.info("Successfully minus balance");
	    }
	    else {
		throw new InsufficientFundException(
			"Too broke, you need more money in your account");
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
