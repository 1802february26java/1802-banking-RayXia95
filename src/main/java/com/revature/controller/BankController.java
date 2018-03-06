package com.revature.controller;

import org.apache.log4j.Logger;

import com.revature.model.User;
import com.revature.repository.BankView;
import com.revature.service.BankService;

public class BankController {

    private User user;
    private BankView bankView;
    private BankService bankService;
    private Logger logger = Logger.getLogger(BankController.class);

    public BankController(User user, BankService bankService, BankView bankView) {
	this.user = user;
	this.bankService = bankService;
	this.bankView = bankView;
    }

    public void widthdraw() {
	bankService.widthdraw(user, bankView.widthdraw());
    }

    public void getBalance() {
	bankView.getBalance(bankService.getBalance(user));
    }

    public void deposit() {
	bankService.deposit(user, bankView.deposit());
    }

    public void login() {
	bankService.authenicateUser(
		bankService.getUserFromDB(user.getUsername(), user.getPassword()),
		bankView.getUsername(), bankView.getPassword());
	bankView.login();
    }

    public void logout() {
	bankService.logout(user);
	bankView.logout();
    }

}
