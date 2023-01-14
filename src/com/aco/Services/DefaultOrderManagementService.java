package com.aco.Services;

import com.aco.Entities.Order;

import java.util.ArrayList;

public class DefaultOrderManagementService implements OrderManagementService {
    private ArrayList<Order> orders;
    private static DefaultOrderManagementService instance;

    {
        orders = new ArrayList<>();
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public ArrayList<Order> getOrdersByUserId(int userId) {
        ArrayList<Order> userOrders = new ArrayList<>();

        for (Order order : orders) {
            if (order.getCustomerId() == userId) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }
}
