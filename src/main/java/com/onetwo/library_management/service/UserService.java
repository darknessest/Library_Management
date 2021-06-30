package com.onetwo.library_management.service;

import com.onetwo.library_management.model.User;

import java.util.List;

public interface UserService {
    abstract List<User> getUsers();

    abstract User getUserById(String id);

    // todo: finish API
}
