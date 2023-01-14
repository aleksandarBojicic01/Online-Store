package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.AdminUser;
import com.aco.Entities.User;
import com.aco.Services.DefaultUserManagementService;
import com.aco.Services.UserManagementService;

import java.util.ArrayList;

public class CustomerListMenu implements Menu {
    private App app;
    private UserManagementService userManagementService;

    {
        app = App.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        ArrayList<User> users = userManagementService.getUsers();

        if (users.isEmpty()) {
            System.out.println("There are no users registered yet!");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
        new AdminMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Customer List*****");
    }
}
