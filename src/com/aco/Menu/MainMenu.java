package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.AdminUser;

import java.util.Scanner;

public class MainMenu implements Menu {
    private App app;

    String LOGGED_IN_USER_TEXT = """
            *****Main Menu*****
            Press:
            1 - to sign out
            2 - to sign up
            3 - to view the product catalog
            4 - to search for a product
            5 - to checkout
            6 - my orders
            7 - settings
            0 - quit
            """;
    String LOGGED_OUT_USER_TEXT = """
            *****Main Menu*****
            Press:
            1 - to sign in
            2 - to sign up
            3 - to view the product catalog
            4 - to search for a product
            5 - to checkout
            6 - my orders
            7 - settings
            0 - quit
            """;
    String LOGGED_IN_ADMIN_TEXT = """
            *****Main Menu*****
            Press:
            1 - to sign out
            2 - to sign up
            3 - to view the product catalog
            4 - to search for a product
            5 - to checkout
            6 - my orders
            7 - settings
            8 - admin menu
            0 - quit
            """;

    String invalidInputMessage = "Only 1, 2, 3, 4, 5, 6, 7, 0 allowed, please try again";

    {
        app = App.getInstance();
    }

    @Override
    public void start() {
        if (app.getCurrentMenu() == null) {
            app.setCurrentMenu(this);
        }

        Menu menuToNavigate = null;

        loop: while (true) {
            printMenuHeader();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Your input: ");
            String input = scanner.next();

            switch (input) {
                case "1":
                    if (app.getCurrentUser() == null)
                        menuToNavigate = new SignInMenu();
                    else
                        menuToNavigate = new SignOutMenu();
                    break loop;
                case "2":
                    menuToNavigate = new SignUpMenu();
                    break loop;
                case "3":
                    menuToNavigate = new ProductCatalogMenu();
                    break loop;
                case "4":
                    menuToNavigate = new ProductSearchMenu();
                    break loop;
                case "5":
                    menuToNavigate = new CheckoutMenu();
                    break loop;
                case "6":
                    menuToNavigate = new MyOrdersMenu();
                    break loop;
                case "7":
                    menuToNavigate = new SettingMenu();
                    break loop;
                case "8":
                    if (app.getCurrentUser() != null && app.getCurrentUser() instanceof AdminUser) {
                        menuToNavigate = new AdminMenu();
                        break loop;
                    } else {
                        System.out.println(invalidInputMessage);
                        break;
                    }
                case "0":
                    System.exit(0);
                default:
                    System.out.println(invalidInputMessage);
            }
        }
        menuToNavigate.start();
    }

    @Override
    public void printMenuHeader() {
        if (app.getCurrentUser() == null) {
            System.out.println(LOGGED_OUT_USER_TEXT);
        } else if (app.getCurrentUser() instanceof AdminUser) {
            System.out.println(LOGGED_IN_ADMIN_TEXT);
        } else {
            System.out.println(LOGGED_IN_USER_TEXT);
        }
    }

}
