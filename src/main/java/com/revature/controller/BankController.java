package com.revature.controller;

import com.revature.exception.DepositByZeroOrLessException;
import com.revature.exception.InsufficientFundException;
import com.revature.model.User;
import com.revature.repository.BankView;
import com.revature.service.BankService;

public class BankController {

    private User user;
    private BankView bankView;
    private BankService bankService;

    public BankController(User user, BankView bankView) {
	this.user = user;
	this.bankView = bankView;
    }

    public void login() {

	String username = bankView.inputUsername();
	String password = bankView.inputPassword();

	/**
	 * SQL to get user
	 */
	User user = new User();
	if (bankService.authenicateUser(user, username, password)) {
	    bankView.login();
	    this.user = user;
	}
	else {
	    bankView.invalidCredentials();
	}
    }

    public void logout() {
	bankView.logout();
	user = null;
    }

    public int getBalance(User user) {

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
