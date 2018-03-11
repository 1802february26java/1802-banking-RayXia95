package com.revature;

import com.revature.controller.BankController;

/**
 * Create an instance of your controller and launch your application.
 *
 * Try not to have any logic at all on this class.
 */
public class Main {

    public static void main(String[] args) {

	BankController controller = new BankController();

	controller.register();

	controller.login();

	controller.getBalance();
	controller.deposit();
	controller.getBalance();
	controller.widthdraw();
	controller.getBalance();

	controller.logout();

    }
}
