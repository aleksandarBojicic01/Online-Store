package com.aco.Entities;

import java.util.ArrayList;

public interface Cart {
    boolean isEmpty();
    void addProduct(Product productById);
    ArrayList<Product> getProducts();
    void clear();
}
