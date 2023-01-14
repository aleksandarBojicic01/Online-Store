package com.aco.Services;

import com.aco.Entities.Product;

import java.util.ArrayList;

public interface ProductManagementService {
    ArrayList<Product> getProducts();
    Product getProductById(int productToAddToCart);

}
