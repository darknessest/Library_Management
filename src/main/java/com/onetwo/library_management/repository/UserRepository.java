package com.onetwo.library_management.repository;

import com.onetwo.library_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //	Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}