package com.driver;

import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        // Initialize the MVC components
        ProductController controller = new ProductController();
        ProductView view = new ProductView();

        // Simple console-based user interface
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    controller.addProduct(productName, quantity);
                    break;

                case 2:
                    List<Product> allProducts = controller.getAllProducts();
                    view.printProductDetails(allProducts);
                    break;

                case 3:
                    System.out.print("Enter product name to update quantity: ");
                    String productNameToUpdate = scanner.next();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    controller.updateProductQuantity(productNameToUpdate, newQuantity);
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }
}

