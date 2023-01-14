package com.aco.Services;

import com.aco.Entities.AdminUser;
import com.aco.Entities.DefaultUser;
import com.aco.Entities.User;

import java.util.ArrayList;

public class DefaultUserManagementService implements UserManagementService {
    private ArrayList<User> users;
    private final String NOT_UNIQUE_EMAIL_MESSAGE = "There is already an user with the same email!";
    private final String ALL_GOOD_MESSAGE = "";

    private static DefaultUserManagementService instance;

    {
        initializeUsers();
    }

    private void initializeUsers() {
        users = new ArrayList<>();
        users.add(new AdminUser("Aleksandar", "Bojicic", "aco123", "aco@email.com"));
        users.add(new AdminUser("Mica", "Moja", "mica123", "mica@email.com"));
        users.add(new DefaultUser("Daco", "Bojicic", "daco123", "daco@email.com"));
        users.add(new DefaultUser("Irena", "Bojicic", "irena123", "irena@email.com"));
    }

    @Override
    public String registerUser(User user) {
        if (!checkEmail(user.getEmail())) {
            return NOT_UNIQUE_EMAIL_MESSAGE;
        }
        users.add(user);
        return ALL_GOOD_MESSAGE;
    }

    public static UserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }

    private boolean checkEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<User> getUsers() {
        return this.users;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user != null && user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
