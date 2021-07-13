package com.onetwo.library_management.service;

import com.onetwo.library_management.entity.User;
import com.onetwo.library_management.exception.NotFoundException;
import com.onetwo.library_management.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUsername(username);

        return optionalUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with username {0} cannot be found.", username)));

    }

    public void signUpUser(User user) {
        final String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        final Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new UsernameNotFoundException(MessageFormat.format("User with id {0} cannot be found.", id)));
    }

    public void updateUser(User user) {
        if (user.getPassword() != "")
            final String possiblyNewPassword = passwordEncoder.encode(user.getPassword());
            if (possiblyNewPassword != user.getPassword())
                user.setPassword(possiblyNewPassword);
        userRepository.save(user);
    }


    public void deleteUser(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id)));

        userRepository.deleteById(user.getId());
    }
}