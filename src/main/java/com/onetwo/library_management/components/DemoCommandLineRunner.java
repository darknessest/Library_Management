package com.onetwo.library_management.components;

import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.entity.UserRole;
import com.onetwo.library_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("admin");
        user.setName("preregistered admin");
        user.setPhone("123456789011");
        user.setEmail("admin@mail.com");
        user.setPassword(passwordEncoder.encode("adminPass"));
        user.setUserRole(UserRole.ADMIN);

        userRepository.save(user);

        user = new User();
        user.setUsername("user1");
        user.setName("preregistered user");
        user.setPhone("110987654321");
        user.setEmail("user1@mail.com");
        user.setPassword(passwordEncoder.encode("user1Pass"));
        user.setUserRole(UserRole.USER);

        userRepository.save(user);
    }
}