package com.onetwo.library_management.dao;

import com.onetwo.library_management.model.User;

import java.util.List;

public interface UserDao {
    abstract List<User> getUsers();

    abstract User getUserById(String id);
}
