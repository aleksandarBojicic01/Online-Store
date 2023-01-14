package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.DefaultUser;
import com.aco.Entities.User;
import com.aco.Services.DefaultUserManagementService;
import com.aco.Services.UserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {
    private UserManagementService userManagementService;
    private App app;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        app = App.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String name = scanner.next();
        System.out.print("Enter your last name: ");
        String lastName = scanner.next();
        System.out.print("Enter your new password: ");
        String password = scanner.next();
        System.out.print("Enter your email: ");

        scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        User user = new DefaultUser(name, lastName, password, email);

        String message = userManagementService.registerUser(user);

        if (message.equals("")) {
            app.setCurrentUser(user);
            System.out.println("New user created!");
        } else {
            System.out.println(message);
        }
        app.getCurrentMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Sign up*****");
    }
}
