package com.revature.model;

import java.io.Serializable;

public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -266883596469560180L;

    private int balance;
    private String name;
    private transient String password;
    private String username;

    public User() {

    }

    public User(String name, String username, String password) {
	this.name = name;
	this.password = password;
	this.username = username;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getBalance() {
	return balance;
    }

    public String getPassword() {
	return password;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setBalance(int balance) {
	this.balance = balance;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + balance;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	User other = (User) obj;
	if (balance != other.balance) {
	    return false;
	}
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	}
	else if (!name.equals(other.name)) {
	    return false;
	}
	if (username == null) {
	    if (other.username != null) {
		return false;
	    }
	}
	else if (!username.equals(other.username)) {
	    return false;
	}
	return true;
    }

}
