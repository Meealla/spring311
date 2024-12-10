package com.example.spring311.service;

import com.example.spring311.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void createUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User showUser(Long id);
}