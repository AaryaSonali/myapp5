package com.sonali.springboot.demo.myapp.rest.service;

import com.sonali.springboot.demo.myapp.rest.dao.UserDAO;
import com.sonali.springboot.demo.myapp.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO)
    {
        userDAO=theUserDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();

    }

    @Override
    @Transactional
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
    userDAO.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
    userDAO.deleteById(id);
    }
}
