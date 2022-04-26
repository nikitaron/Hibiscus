package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.Passport;
import com.poit.hibiscus.entity.User;
import com.poit.hibiscus.repository.UserRepository;
import com.poit.hibiscus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(String email, Passport passport) {
        userRepository.updateUser(email, passport);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
