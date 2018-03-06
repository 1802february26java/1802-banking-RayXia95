package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.controller.BankController;
import com.revature.exception.DepositByZeroOrLessException;
import com.revature.exception.InsufficientFundException;
import com.revature.model.User;

public class BankService {

    Logger log = Logger.getLogger(BankController.class);

    public boolean authenicateUser(User user, String username, String password) {
	if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	    log.info("User has sucessfully logged in");
	    return true;
	}

	return false;
    }

    public int getBalance(User user) {

	log.info("Your Balance is: " + user.getBalance());
	return user.getBalance();

    }

    public void deposit(User user, int amount) {
	try {
	    if (amount > 0) {
		user.setBalance(user.getBalance() + amount);
	    }
	    else {
		throw new DepositByZeroOrLessException("You have to have money to put money in");
	    }

	}
	catch (DepositByZeroOrLessException e) {
	    log.warn("You gotta have money to put in");
	}
    }

    public int widthdraw(User user, int widthdraw) {
	try {
	    if (user.getBalance() >= widthdraw) {
		user.setBalance(user.getBalance() - widthdraw);
	    }
	    else {
		throw new InsufficientFundException(
			"Too Broke you need more money in your account");
	    }

	}
	catch (InsufficientFundException e) {
	    log.warn("You can not widthdraw that amount!");
	}

	return user.getBalance();
    }

    public void logout(User user) {
	user = null;
	log.info("User has successfully logged out");
	return;
    }
}
