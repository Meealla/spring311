package com.example.spring311.dao;

import com.example.spring311.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User showUser(Long id);
}