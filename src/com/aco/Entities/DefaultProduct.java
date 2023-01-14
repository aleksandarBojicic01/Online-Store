package com.aco.Entities;

public class DefaultProduct implements Product {
    private int id;
    private String name;
    private String category;
    private double price;

    public DefaultProduct(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getProductName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Product id: " + id + ", | Name: " + name + ", | Category: " + category + ", | Price: " + price + "$" + "\n";
    }
}
