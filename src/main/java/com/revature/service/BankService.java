package com.revature.service;

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
	User user = new UserDAOImpl().getUserByUsername(username);
	try {
	    if (user.getPassword().equals(password)) {
		logger.info("Successfully gotten user from DB");
		return user;
	    }
	    else {
		throw new IllegalArgumentException();
	    }
	}
	catch (NullPointerException e) {
	    logger.error("Could not get user by username, username does not exists");
	}
	catch (IllegalArgumentException e) {
	    logger.error("Wrong password");
	}
	return null;
    }

    public double getBalance(User user) {
	logger.info("Got balance");
	try {
	    return new UserDAOImpl().getUserByUsername(user.getUsername()).getBalance();
	}
	catch (NullPointerException e) {
	    logger.error("No balance with the account");
	}
	return 0;
    }

    public void deposit(User user, double amount) {
	try {
	    if (amount > 0) {
		new UserDAOImpl().updateUserBalance(user.getUsername(), (getBalance(user) + amount));
		logger.info("Successfully added balance");
	    }
	    else {
		throw new DepositByZeroOrLessException();
	    }

	}
	catch (DepositByZeroOrLessException e) {
	    logger.error("You have to have money to put money in");
	}
	catch (NullPointerException e) {
	    logger.error("Can't put balance to a non existing account");
	}
    }

    public void widthdraw(User user, double widthdraw) {
	try {
	    if (widthdraw < 0) {
		throw new IllegalWidthdrawlException();
	    }
	    if (user.getBalance() >= widthdraw) {
		new UserDAOImpl().updateUserBalance(user.getUsername(), (getBalance(user) - widthdraw));
		logger.info("Successfully minus balance");
	    }
	    else {
		throw new InsufficientFundException();
	    }
	}
	catch (IllegalWidthdrawlException e) {
	    logger.error("Cannot widthdraw negative amount");
	}
	catch (InsufficientFundException d) {
	    logger.error("Too broke, you need more money in your account");
	}
	catch (NullPointerException f) {
	    logger.error("Cannot widthdraw from an existing account");
	}

    }

    public User logout(User user) {
	user = null;
	logger.info("User does not exist anymore and logged off");
	return user;
    }
}
