package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.service.BankService;
import com.revature.view.BankView;

public class BankController {

    private User user = new User();
    private BankView bankView = new BankView();
    private BankService bankService = new BankService();
    private static final Logger logger = Logger.getLogger(BankController.class);

    public BankController() {
	logger.info("Initialized Controller");
    }

    public void register() {
	bankService.registerUser(bankView.register());
	logger.info("Registered user");
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
	String username = bankView.getUsername();
	String password = bankView.getPassword();
	user = bankService.getUserFromDB(username, password);
	bankView.login();
	logger.info("Successfully logged in");
    }

    public void logout() {
	user = bankService.logout(user);
	bankView.logout();
	logger.info("Successfully logged out");
    }

}
