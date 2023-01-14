package com.aco.Menu;

import com.aco.Aplication.App;
import com.aco.Entities.Order;
import com.aco.Services.DefaultOrderManagementService;
import com.aco.Services.OrderManagementService;

import java.util.ArrayList;

public class MyOrdersMenu implements Menu {
    private OrderManagementService orderManagementService;
    private App app;

    {
        orderManagementService = DefaultOrderManagementService.getInstance();
        app = App.getInstance();
    }

    @Override
    public void start() {
        if (app.getCurrentUser() == null) {
            System.out.println("Log in to view your orders!");
            new MainMenu().start();
        }
        if (orderManagementService.getOrders() == null || orderManagementService.getOrders().isEmpty()) {
            System.out.println("You don't have any orders yet, check back on this menu after you have completed an order!");
            new MainMenu().start();
        }

        printMenuHeader();

        ArrayList<Order> currentUserOrders = orderManagementService.getOrdersByUserId(app.getCurrentUser().getId());
        for (Order order : currentUserOrders) {
            System.out.println(order);
        }
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****My Orders*****");
    }
}
