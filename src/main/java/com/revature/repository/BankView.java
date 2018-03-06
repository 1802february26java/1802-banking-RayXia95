package com.revature.repository;

import java.util.Scanner;

import com.revature.model.User;

public class BankView {

    private Scanner input = new Scanner(System.in);

    public String inputUsername() {
	System.out.println("Please enter your username ");
	return input.nextLine();
    }

    public String inputPassword() {
	System.out.println("Please enter your password ");
	return input.nextLine();
    }

    public void getBalance(User user) {
	System.out.println("Your Balance is: ");
	System.out.println(user.getBalance());
    }

    public int widthdraw() {
	System.out.println("Please enter how much you want to widthdraw: ");
	return input.nextInt();
    }

    public int deposit() {
	System.out.println("Please enter how much you want to deposit: ");
	return input.nextInt();
    }

    public void invalidCredentials() {
	System.out.println("Invalid Credentials please try again");
    }

    public void login() {
	System.out.println("Login Succesfull");
    }

    public void logout() {
	System.out.println("logout Succesfull");
    }
}
