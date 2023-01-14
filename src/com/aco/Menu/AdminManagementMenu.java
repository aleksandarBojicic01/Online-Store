package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.AdminUser;
import com.aco.Entities.Order;
import com.aco.Entities.User;
import com.aco.Services.DefaultOrderManagementService;
import com.aco.Services.DefaultUserManagementService;
import com.aco.Services.OrderManagementService;
import com.aco.Services.UserManagementService;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminManagementMenu implements Menu {
    private UserManagementService userManagementService;
    private App app;
    private OrderManagementService orderManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        app = App.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
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
    // trenutno uklanja cijelog korisnika ne samo admin status
    private boolean removeAdmin(String adminEmail) {
        AdminUser adminUserToRemove = null;
        boolean removedFlag = false;

        for (User user : userManagementService.getUsers()) {
            if (user.getEmail().equalsIgnoreCase(adminEmail) && user instanceof AdminUser) {
                adminUserToRemove = (AdminUser) user;
                removedFlag = true;
            }
        }
        userManagementService.getUsers().remove(adminUserToRemove);

        return removedFlag;
    }
    //za kasnije
    // kad se napravi admin brise mu se istorija, pronaci novi nacin da se ovo izvede
    private boolean makeNewAdmin(String userEmail) {
        boolean madeFlag = false;
        AdminUser adminUser = null;
        User userToRemove = null;

        for (User user : userManagementService.getUsers()) {
            if (user.getEmail().equalsIgnoreCase(userEmail) && !(user instanceof AdminUser)) {
                adminUser = new AdminUser(user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail());
                userToRemove = user;
                madeFlag = true;
                break;
            }
        }
        if (madeFlag) {
            ArrayList<Order> oldUserOrders = orderManagementService.getOrdersByUserId(userToRemove.getId());
            orderManagementService.getOrdersByUserId(adminUser.getId()).addAll(oldUserOrders);
            userManagementService.getUsers().remove(userToRemove);
            userManagementService.getUsers().add(adminUser);
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
