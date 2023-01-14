package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.Product;
import com.aco.Services.DefaultProductManagementService;
import com.aco.Services.ProductManagementService;

import java.util.Scanner;

public class ProductCatalogMenu implements Menu {
    private ProductManagementService productManagementService;
    private App app;

    {
        productManagementService = DefaultProductManagementService.getInstance();
        app = App.getInstance();
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        while (true) {
            printMenuHeader();
            printCatalog();
            int input = readInput();

            if (input == 0) {
                menuToNavigate = new MainMenu();
                break;
            }

            if (app.getCurrentUser() == null) {
                System.out.println("You need to log in or sign up to add products to cart!");
                menuToNavigate = new MainMenu();
                break;
            }

            if (fetchProduct(input) != null) {
                addProductToCart(fetchProduct(input));
                System.out.printf("Added %s to cart!\n", fetchProduct(input).getProductName());
            } else {
                System.out.println("Unsupported input, please enter product id to add it to your cart or type 0 to go back to the main menu\n");
            }
        }
        menuToNavigate.start();
    }

    private Product fetchProduct(int productId) {
        return productManagementService.getProductById(productId);
    }

    private void addProductToCart(Product product) {
        app.getCurrentUserCart().addProduct(product);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Catalog*****");
        System.out.println("Type the product number to add it to your cart, otherwise type 0 to go back to the main menu");
    }

    private void printCatalog() {
        for (Product product : productManagementService.getProducts()) {
            System.out.printf("%d. %s - %.2f$\n", product.getId(), product.getProductName(), product.getPrice());
        }
    }

    private int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
