package com.aco.Entities;

import java.util.ArrayList;

public class DefaultCart implements Cart {
    private ArrayList<Product> products;

    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return this.products;
    }

    @Override
    public void clear() {
        this.products = new ArrayList<>();
    }
}
