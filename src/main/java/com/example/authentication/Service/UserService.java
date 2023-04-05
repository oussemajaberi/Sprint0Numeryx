package com.example.authentication.Service;

import com.example.authentication.Entity.Role;
import com.example.authentication.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
