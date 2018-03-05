package com.revature.controller;

import com.revature.model.User;

public class BankController {

    private User user;

    public boolean authenicateUser(String username, String password) {
	if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	    return true;
	}
	return false;
    }

}
