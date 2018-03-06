package com.revature.view;

import java.util.Scanner;

public class BankView {

    private Scanner input = new Scanner(System.in);

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

    public void invalidCredentials() {
	System.out.println("Invalid Credentials please try again");
    }

    public void login() {
	System.out.println("Login Succesfully");
    }

    public void logout() {
	input.close();
	System.out.println("logout Succesfully");
    }
}
