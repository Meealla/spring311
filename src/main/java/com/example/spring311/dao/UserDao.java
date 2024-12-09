package com.example.spring311.dao;



import com.example.spring311.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getByIdUser(Long id);

    void save(User user);

    void update(Long id, User updateUser);

    void delete(Long id);
}