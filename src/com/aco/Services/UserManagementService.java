package com.aco.Services;

import com.aco.Entities.User;

import java.util.ArrayList;

public interface UserManagementService {
    String registerUser(User user);
    ArrayList<User> getUsers();
    User getUserByEmail(String email);
}
