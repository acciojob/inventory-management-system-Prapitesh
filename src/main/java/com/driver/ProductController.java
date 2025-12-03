package com.driver;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<Product> products = new ArrayList<>();

    public void addProduct(String name, int quantity) {
    	Product p=new Product(name,quantity);
        products.add(p);
    }

    public List<Product> getAllProducts() {
    	//your code goes here
        return new ArrayList<>(products);
    }

    public void updateProductQuantity(String name, int newQuantity) {
        for(Product p1:products){
            String pname=p1.getName();
            if(pname.toLowerCase().equalsIgnoreCase(name)){
                 p1.setQuantity(newQuantity);
                 break;
            }
        }

    }
}
