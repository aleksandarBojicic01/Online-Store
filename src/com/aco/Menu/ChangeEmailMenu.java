package com.aco.Menu;

import com.aco.Aplication.App;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {
    private App app;

    {
        app = App.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your new email: ");
        String email = scanner.next();

        app.getCurrentUser().setEmail(email);
        System.out.println("Email changed successfully!");

        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Change Email*****");
    }
}
