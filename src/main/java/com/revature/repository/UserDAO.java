package com.revature.repository;

import java.util.List;

import com.revature.model.User;

public interface UserDAO {

    public List<User> getAllUser();

    public User getUserByUsername(String username);

    public boolean registerUser(String username, String password, String name, int balance);

    public boolean deleteUser(String username);

    public boolean updateUserBalance(String username, int balance);

}
