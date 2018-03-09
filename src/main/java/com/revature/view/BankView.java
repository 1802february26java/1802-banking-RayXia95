package com.revature.view;

import java.util.Scanner;

import com.revature.model.User;

public class BankView {

    private Scanner input = new Scanner(System.in);

    public User register() {
	User user = new User();
	try {
	    System.out.println("Please enter a username");
	    user.setUsername(input.nextLine());
	    System.out.println("Please enter a password");
	    user.setPassword(input.nextLine());
	    System.out.println("Please enter a name");
	    user.setName(input.nextLine());
	    System.out.println("Please enter current deposit");
	    user.setBalance(input.nextDouble());
	}
	catch (IllegalArgumentException e) {
	    System.out.println("Username taken");
	    e.printStackTrace();
	}
	return user;

    }

    public String getUsername() {
	System.out.println("Please enter your username ");
	return input.nextLine();
    }

    public String getPassword() {
	System.out.println("Please enter your password ");
	return input.nextLine();
    }

    public void getBalance(double d) {
	System.out.println("Your Balance is: ");
	System.out.println(d);
    }

    public int widthdraw() {
	System.out.println("Please enter how much you want to widthdraw: ");
	return input.nextInt();
    }

    public int deposit() {
	System.out.println("Please enter how much you want to deposit: ");
	return input.nextInt();
    }

    public void login() {
	System.out.println("Login Succesfully");
    }

    public void logout() {
	input.close();
	System.out.println("logout Succesfully");
    }
}
