package com.aco.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultOrder implements Order {
    private final int AMOUNT_OF_DIGITS_IN_CARD_NUMBER = 16;

    private ArrayList<Product> products;
    private String creditCardNumber;
    private int customerId;

    @Override
    public boolean isCardNumberValid(String creditCardNumber) {
        return (creditCardNumber.length() == AMOUNT_OF_DIGITS_IN_CARD_NUMBER
            && !creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0);
    }

    @Override
    public void setCardNumber(String number) {
        if (number == null) {
            return;
        }
        this.creditCardNumber = number;
    }

    @Override
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public void setCustomerId(int id) {
        this.customerId = id;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order:\n" +
                "Customer id: " + getCustomerId() + "\n" +
                "Credit card number: " + creditCardNumber + "\n" +
                "Products: \n" + products.toString();

    }
}
