package com.driver;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<Product> products = new ArrayList<>();

    public void addProduct(String name, int quantity) {
    	//your code goes here
    }

    public List<Product> getAllProducts() {
    	//your code goes here
        return new ArrayList<>(products);
    }

    public void updateProductQuantity(String name, int newQuantity) {
    	//your code goes here
    }
}
