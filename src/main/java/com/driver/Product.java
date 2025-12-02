package com.driver;

public class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
    	//your code goes here
        return name;
    }

    public int getQuantity() {
    	//your code goes here
        return quantity;
    }

    public void setQuantity(int quantity) {
    	//your code goes here
        this.quantity = quantity;
    }

    @Override
    public String toString() {
    	//your code goes here
        return "Product [name=" + name + ", quantity=" + quantity + "]";
    }
}
