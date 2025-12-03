package com.driver.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.driver.Product;
import com.driver.ProductController;
import com.driver.ProductView;

class TestCases {

    private ProductController controller;
    private ProductView view;

    @BeforeEach
    void setup() {
        controller = new ProductController();
        view = new ProductView();
    }

    @Test
    void testAddProduct() {
        controller.addProduct("Laptop", 10);
        List<Product> products = controller.getAllProducts();

        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
        assertEquals(10, products.get(0).getQuantity());
    }

    @Test
    void testGetAllProducts() {
        controller.addProduct("Phone", 5);
        controller.addProduct("Mouse", 20);

        List<Product> products = controller.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("Phone", products.get(0).getName());
        assertEquals(5, products.get(0).getQuantity());
        assertEquals("Mouse", products.get(1).getName());
        assertEquals(20, products.get(1).getQuantity());
    }

    @Test
    void testUpdateProductQuantity() {
        controller.addProduct("Keyboard", 15);
        controller.updateProductQuantity("Keyboard", 30);

        List<Product> products = controller.getAllProducts();

        assertEquals(30, products.get(0).getQuantity());
    }

    @Test
    void testUpdateQuantityCaseInsensitive() {
        controller.addProduct("Monitor", 12);
        controller.updateProductQuantity("monitor", 25);

        List<Product> products = controller.getAllProducts();

        assertEquals(25, products.get(0).getQuantity());
        assertEquals("Monitor", products.get(0).getName());
    }

    @Test
    void testViewPrintOutput() {
        controller.addProduct("Book", 7);
        controller.addProduct("Pen", 50);

        List<Product> products = controller.getAllProducts();

        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        view.printProductDetails(products);

        String output = outContent.toString();
        // Just check if printed list contains product names
        assertEquals(true, output.contains("Book"));
        assertEquals(true, output.contains("Pen"));
    }
}
