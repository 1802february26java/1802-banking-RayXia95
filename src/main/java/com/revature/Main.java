package com.revature;

import com.revature.controller.BankController;
import com.revature.model.User;
import com.revature.service.BankService;
import com.revature.view.BankView;

/**
 * Create an instance of your controller and launch your application.
 *
 * Try not to have any logic at all on this class.
 */
public class Main {

    public static void main(String[] args) {

	User user = new User();
	BankService bankService = new BankService();
	BankView view = new BankView();

	BankController controller = new BankController(user, bankService, view);
	controller.login();

	controller.getBalance();
	controller.deposit();
	controller.getBalance();
	controller.widthdraw();
	controller.getBalance();

	controller.logout();

    }
}
