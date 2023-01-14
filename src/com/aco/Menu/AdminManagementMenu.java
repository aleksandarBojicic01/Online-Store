package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.User;
import com.aco.Services.DefaultUserManagementService;
import com.aco.Services.UserManagementService;

import java.util.Scanner;

public class AdminManagementMenu implements Menu {
    private UserManagementService userManagementService;
    private App app;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        app = App.getInstance();
    }

    @Override
    public void start() {
        loop: while (true) {
            printMenuHeader();

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            switch (input) {
                case "1" -> {
                    System.out.print("Enter the email of the user you wish to make admin: ");
                    input = scanner.next();
                    if (makeNewAdmin(input)) {
                        System.out.println("Admin added!");
                    } else {
                        System.out.println("No user with that email exists or user is already admin!");
                    }
                }
                case "2" -> {
                    System.out.print("Enter the email of the admin you wish to remove: ");
                    input = scanner.next();
                    if (removeAdmin(input)) {
                        System.out.println("Admin removed!");
                    } else {
                        System.out.println("No admin with that email exists!");
                    }
                }
                case "0" -> {
                    new AdminMenu().start();
                    break loop;
                }
                default -> System.out.println("Unsupported input!");
            }
        }
    }

    private boolean removeAdmin(String adminEmail) {
        boolean removedFlag = false;
        User user = userManagementService.getUserByEmail(adminEmail);

        if (user != null && user.isAdmin()) {
            user.setAdminStatus(false);
            removedFlag = true;
        }
        return removedFlag;
    }

    private boolean makeNewAdmin(String userEmail) {
        boolean madeFlag = false;
        User user = userManagementService.getUserByEmail(userEmail);

        if (user != null && !user.isAdmin()) {
            user.setAdminStatus(true);
            madeFlag = true;
        }
        return madeFlag;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("""
                *****Add Or Remove Admins*****
                Press:
                1 - to add a new admin
                2 - to remove an admin
                0 - back to Admin Menu
                """);
    }
}
