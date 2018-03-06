package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.Main;
import com.revature.model.User;
import com.revature.service.BankService;
import com.revature.view.BankView;

public class BankController {

    private User user;
    private BankView bankView;
    private BankService bankService;
    private static Logger logger = Logger.getLogger(Main.class);

    public BankController(User user, BankService bankService, BankView bankView) {
	this.user = user;
	this.bankService = bankService;
	this.bankView = bankView;
	logger.info("Ininitalized Controller");
    }

    public void widthdraw() {
	bankService.widthdraw(user, bankView.widthdraw());
	logger.info("widthdrew money");
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
	bankService.authenicateUser(
		bankService.getUserFromDB(user.getUsername(), user.getPassword()),
		bankView.getUsername(), bankView.getPassword());
	bankView.login();
	logger.info("Successfully logged in");
    }

    public void logout() {
	user = bankService.logout(user);
	bankView.logout();
	logger.info("Succesffuly logged out");
    }

}
