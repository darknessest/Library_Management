package com.onetwo.library_management.service;

import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.repository.UserRepository;
import com.onetwo.library_management.configuration.WebSecurityConfig;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loading user: " + username);
        final Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with username {0} cannot be found.", username)));

    }

    public void signUpUser(User user) {

        final String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);

    }

}