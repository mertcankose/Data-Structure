package com.company;

public class Product {
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println(" Product Name: " + this.name);
        System.out.println(" Description: " + this.description);
        System.out.println(" Price: " + this.price);
    }
    public String getName() {
        return this.name;
    }

    /*
    @Override
    public String toString() {
        return "Name: " + this.name + " Description: "+ this.description + " Price: "  + this.price;
    }
    */
}
