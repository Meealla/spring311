package com.example.spring311.dao;


import com.example.spring311.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }

    public User getByIdUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(Long id, User updateUser) {
        User userToBeUpdate = getByIdUser(id);
        userToBeUpdate.setName(updateUser.getName());
        userToBeUpdate.setEmail(updateUser.getEmail());
    }

    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}