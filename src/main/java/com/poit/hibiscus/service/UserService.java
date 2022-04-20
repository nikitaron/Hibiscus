package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.Passport;
import com.poit.hibiscus.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(Long id, Passport passport);
    User findUserById(Long id);
    User findUserByEmail(String email);
    List<User> getUsers();
}
