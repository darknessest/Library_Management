package com.onetwo.library_management.service.impl;

import com.onetwo.library_management.dao.UserDao;
import com.onetwo.library_management.model.User;
import com.onetwo.library_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

}
