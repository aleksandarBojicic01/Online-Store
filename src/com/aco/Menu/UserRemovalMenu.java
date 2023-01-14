package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.User;
import com.aco.Services.DefaultUserManagementService;
import com.aco.Services.UserManagementService;

import java.util.Scanner;

public class UserRemovalMenu implements Menu {
    private App app;
    private UserManagementService userManagementService;

    {
        app = App.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        while (true) {
            printMenuHeader();

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            if (input.equals("0")) {
                break;
            }

            User userToRemove = userManagementService.getUserByEmail(input);
            if (userToRemove != null && !(userToRemove.isAdmin()) && userToRemove != app.getCurrentUser()) {
                for (User user : userManagementService.getUsers()) {
                    if (user.getEmail().equalsIgnoreCase(input)) {
                        userToRemove = user;
                    }
                }
                userManagementService.getUsers().remove(userToRemove);
                System.out.println("User removed!");
                break;
            } else {
                System.out.println("No user with such an email found!");
            }
        }
        new AdminMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.print("*****User Removal*****\n" +
                "Type the email of the user you wish to remove, otherwise type 0 to go back to the admin menu: ");
    }
}
