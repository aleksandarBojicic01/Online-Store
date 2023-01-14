package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.User;
import com.aco.Services.DefaultUserManagementService;
import com.aco.Services.UserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {
    private App app;
    private UserManagementService userManagementService;

    {
        app = App.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User user = userManagementService.getUserByEmail(email);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                app.setCurrentUser(user);

                System.out.printf("Welcome %s %s, glad to see you back!\n", user.getFirstName(), user.getLastName());
            } else {
                System.out.println("Password does not match email!\n");
            }
        } else {
            System.out.println("No user with that email exists, check email or sign up!\n");
        }
        app.getCurrentMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Sign In*****");
    }
}
