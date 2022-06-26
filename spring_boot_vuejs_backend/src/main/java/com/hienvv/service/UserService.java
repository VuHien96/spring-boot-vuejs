package com.hienvv.service;

import com.hienvv.entity.Role;
import com.hienvv.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User addUser(User user);
    Optional<User> findByUsername(String username);
    void changeRole(String username, Role role);
}
