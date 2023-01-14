package com.aco.Menu;

import java.util.Scanner;

public class AdminMenu implements Menu {

    @Override
    public void start() {
        printMenuHeader();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        loop: while (true) {
            switch (input) {
                case "1":
                    new CustomerListMenu().start();
                    break loop;
                case "2":
                    new UserRemovalMenu().start();
                    break loop;
                case "3":
                    new AdminManagementMenu().start();
                    break loop;
                case "0":
                    new MainMenu().start();
                    break loop;
                default:
                    System.out.println("Unsupported input");
                    break;
            }
        }
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("""
                *****Admin Menu*****
                Press:
                1 - to view the user list
                2 - to remove user
                3 - to manage admins
                0 - to go back to the menu
                """);
    }
}
