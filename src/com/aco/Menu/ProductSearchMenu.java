package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.Product;
import com.aco.Services.DefaultProductManagementService;
import com.aco.Services.ProductManagementService;

import java.util.Scanner;

public class ProductSearchMenu implements Menu {
    private ProductManagementService productManagementService;
    private App app;

    {
        productManagementService = DefaultProductManagementService.getInstance();
        app = App.getInstance();
    }

    private boolean listFoundProducts(String productToLookFor) {
        boolean foundFlag = false;
        for (Product product : productManagementService.getProducts()) {
            if (product.getProductName().toLowerCase().contains(productToLookFor)) {
                System.out.printf("%d. %s - %.2f$\n", product.getId(), product.getProductName(), product.getPrice());
                foundFlag = true;
            }
        }
        return foundFlag;
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        outer: while (true) {
            printMenuHeader();

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            while (true) {
                if (listFoundProducts(input)) {
                    System.out.println("Type the product id number to add it to your cart, if you didn't find what you were " +
                            "looking for type '0' to search again, otherwise type 'menu' to go back to the main menu.");
                    String command = scanner.next();

                    if (command.equalsIgnoreCase("menu")) {
                        menuToNavigate = new MainMenu();
                        break outer;
                    }
                    if (command.equals("0")) {
                        continue outer;
                    }

                    if (app.getCurrentUser() == null) {
                        System.out.println("You need to log in or sign up to add products to cart!");
                        menuToNavigate = new MainMenu();
                        break outer;
                    }

                    int id = Integer.parseInt(command);
                    Product product = productManagementService.getProductById(id);

                    if (product != null) {
                        app.getCurrentUserCart().addProduct(product);
                        System.out.printf("%s added to cart\n", product.getProductName());
                    } else {
                        System.out.println("No product found with that id!");
                    }
                } else {
                    System.out.printf("No product found for the query %s!\n", input);
                    menuToNavigate = new MainMenu();
                    break outer;
                }
            }
        }
        menuToNavigate.start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Search*****");
        System.out.print("Type what you are looking for (in lowercase): ");
    }
}
