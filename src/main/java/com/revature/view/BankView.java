package com.revature.view;

import java.util.Scanner;

import com.revature.model.User;

public class BankView {

    private Scanner input = new Scanner(System.in);

    public User register() {
	User user = new User();
	System.out.println("You are registering a user");
	System.out.println("Please enter a username");
	user.setUsername(input.next());
	System.out.println("Please enter a password");
	user.setPassword(input.next());
	System.out.println("Please enter a name");
	user.setName(input.next());
	System.out.println("Please enter current deposit");
	user.setBalance(input.nextDouble());
	return user;
    }

    public String getUsername() {
	System.out.println("Please enter your username ");
	return input.next();
    }

    public String getPassword() {
	System.out.println("Please enter your password ");
	return input.next();
    }

    public void getBalance(double d) {
	System.out.println("Your Balance is: ");
	System.out.println(d);
    }

    public double widthdraw() {
	System.out.println("Please enter how much you want to widthdraw: ");
	return input.nextDouble();
    }

    public double deposit() {
	System.out.println("Please enter how much you want to deposit: ");
	return input.nextDouble();
    }

    public void login() {
	System.out.println("Please login");
    }

    public void logout() {
	input.close();
	System.out.println("logout Succesfully");
    }
}
