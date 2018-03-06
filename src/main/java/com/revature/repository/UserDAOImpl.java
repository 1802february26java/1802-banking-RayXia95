package com.revature.repository;

import java.util.List;

import com.revature.model.User;


public class UserDAOImpl implements UserDAO {

    @Override
    public List<User> getAllUser() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public User getUserByUsername(String username) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean registerUser(String username, String password, String name, int balance) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean deleteUser(String username) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean updateUserBalance(String username, int balance) {
	// TODO Auto-generated method stub
	return false;
    }

}
