package com.aco.Services;

import com.aco.Entities.Order;

import java.util.ArrayList;

public interface OrderManagementService {
    void addOrder(Order order);
    ArrayList<Order> getOrdersByUserId(int userId);
    ArrayList<Order> getOrders();

}
