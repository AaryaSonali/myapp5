package com.sonali.springboot.demo.myapp.rest.dao;

import com.sonali.springboot.demo.myapp.rest.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();

    public User findById(int id);

    public void save(User user);

    public void deleteById(int id);
}
