package com.rajat_agarwal.Tax_Calculator.service;

import com.rajat_agarwal.Tax_Calculator.entities.User;

import java.util.List;

public interface UserService {

    public User registerNewUser(User user);

    public void deleteUser(String userName);

    public User updateUser(User user, String userName);

    public User changePassword(User user, String userName);

    public User getUserById(String userName);

    public List<User> getAllUser();
}
