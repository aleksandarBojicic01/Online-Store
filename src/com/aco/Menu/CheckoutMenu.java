package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.DefaultOrder;
import com.aco.Entities.Order;
import com.aco.Services.DefaultOrderManagementService;
import com.aco.Services.DefaultProductManagementService;
import com.aco.Services.OrderManagementService;
import com.aco.Services.ProductManagementService;

import java.util.Scanner;

public class CheckoutMenu implements Menu {
    private OrderManagementService orderManagementService;
    private App app;

    {
        orderManagementService = DefaultOrderManagementService.getInstance();
        app = App.getInstance();
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        while (true) {
            if (app.getCurrentUser() == null) {
                System.out.println("You must log in to checkout!");
                menuToNavigate = new MainMenu();
                break;
            }

            if (app.getCurrentUserCart().isEmpty() || app.getCurrentUserCart() == null) {
                System.out.println("Your cart is empty, there is nothing to checkout!");
                menuToNavigate = new MainMenu();
                break;
            }

            printMenuHeader();

            Scanner scanner = new Scanner(System.in);
            String cardNumber = scanner.next();

            if (!createOrder(cardNumber)) {
                System.out.println("Wrong credit card number, try again!");
                continue;
            }
            menuToNavigate = new MainMenu();
            System.out.println("Checkout successful, thank you for your order!");
            break;
        }
        app.getCurrentUserCart().clear();
        menuToNavigate.start();
    }

    private boolean createOrder(String cardNumber) {
        Order order = new DefaultOrder();
        if (!order.isCardNumberValid(cardNumber)) {
            return false;
        }
        order.setCardNumber(cardNumber);
        order.setProducts(app.getCurrentUserCart().getProducts());
        order.setCustomerId(app.getCurrentUser().getId());
        orderManagementService.addOrder(order);
        return true;
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****Checkout*****");
        System.out.print("Your credit card number (without spaces): ");
    }
}
