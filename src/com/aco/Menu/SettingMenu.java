package com.aco.Menu;

import com.aco.Aplication.App;

import java.util.Scanner;

public class SettingMenu implements Menu {
    private App app;

    {
        app = App.getInstance();
    }

    @Override
    public void start() {
        if (app.getCurrentUser() == null) {
            System.out.println("Please log in to adjust settings!");
            new MainMenu().start();
            return;
        }

        loop: while (true) {
            printMenuHeader();

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    new ChangePasswordMenu().start();
                    break loop;
                case 2:
                    new ChangeEmailMenu().start();
                    break loop;
                case 0:
                    new MainMenu().start();
                    break loop;
                default:
                    System.out.println("Invalid command, type either 1, 2 or 0");
            }
        }
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("""
                            *****Settings*****
                            1 - Change password
                            2 - Change email
                            0 - Main menu""");
    }
}
