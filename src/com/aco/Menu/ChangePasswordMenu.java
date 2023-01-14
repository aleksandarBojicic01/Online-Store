package com.aco.Menu;

import com.aco.Aplication.App;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {
    private App app;

    {
        app = App.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Type your new password: ");
        String newPassword1 = scanner.next();
        System.out.print("Please confirm your password: ");
        String newPassword2 = scanner.next();

        if (newPassword2.equals(newPassword1)) {
            app.getCurrentUser().setPassword(newPassword1);
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Passwords don't match, please try again!");
        }
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Change Password*****");
    }
}
