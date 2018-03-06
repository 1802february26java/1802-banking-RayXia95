package com.revature.service;

import com.revature.exception.DepositByZeroOrLessException;
import com.revature.exception.InsufficientFundException;
import com.revature.exception.InvalidCredentials;
import com.revature.model.User;

public class BankService {

    public void authenicateUser(User user, String username, String password) {
	try {
	    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	    }
	    else {
		throw new InvalidCredentials("Username or password is incorrect");
	    }
	}
	catch (InvalidCredentials e) {

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
	String savedUsername = "";
	String savedPassword = "";
	String name = "";
	int balance = 0;

	user.setName(name);
	user.setUsername(savedUsername);
	user.setPassword(savedPassword);
	user.setBalance(balance);
	return user;
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

	}
    }

    public void widthdraw(User user, int widthdraw) {
	try {
	    if (user.getBalance() >= widthdraw) {
		user.setBalance(user.getBalance() - widthdraw);
	    }
	    else {
		throw new InsufficientFundException(
			"Too broke you need more money in your account");
	    }
	}
	catch (InsufficientFundException e) {

	}

    }

    public void logout(User user) {
	user = null;
    }
}
