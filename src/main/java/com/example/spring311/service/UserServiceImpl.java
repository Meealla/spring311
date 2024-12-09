package com.example.spring311.service;

import com.example.spring311.dao.UserDao;
import com.example.spring311.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getByIdUser(Long id) {
        return userDao.getByIdUser(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, User updateUser) {
        userDao.update(id, updateUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
}