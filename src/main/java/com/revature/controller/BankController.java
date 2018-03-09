package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.service.BankService;
import com.revature.view.BankView;

public class BankController {

    private User user;
    private BankView bankView;
    private BankService bankService;
    private static final Logger logger = Logger.getLogger(BankController.class);

    public BankController(User user, BankService bankService, BankView bankView) {
	this.user = user;
	this.bankService = bankService;
	this.bankView = bankView;
	logger.info("Initialized Controller");
    }

    public void register() {
	user = bankView.register();
    }

    public void widthdraw() {
	bankService.widthdraw(user, bankView.widthdraw());
	logger.info("withdrew money");
    }

    public void getBalance() {
	bankView.getBalance(bankService.getBalance(user));
	logger.info("Got balance of account");
    }

    public void deposit() {
	bankService.deposit(user, bankView.deposit());
	logger.info("Deposited money in bank account");
    }

    public void login() {
	user = bankService.getUserFromDB(bankView.getUsername(), bankView.getPassword());
	bankView.login();
	logger.info("Successfully logged in");
    }

    public void logout() {
	user = bankService.logout(user);
	bankView.logout();
	logger.info("Successfully logged out");
    }

}
