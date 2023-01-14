package com.aco.Entities;

import java.util.ArrayList;

public interface Order {
    boolean isCardNumberValid(String input);
    void setCardNumber(String cardNumber);
    void setProducts(ArrayList<Product> products);
    void setCustomerId(int id);
    int getCustomerId();
}
