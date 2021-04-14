package com.company;

public class TestProductArray {

    public static void main(String[] args) {
        ProductArray products = new ProductArray(50);

        Product product1 = new Product("ASUS X415JA", "CORE I5 8GB RAM", 6550.0);
        Product product2 = new Product("EVERPAD SC-730", "SPACEGRAY-BLUETOOTH", 6550.0);
        Product product3 = new Product("HOMETECH ALFA", "8GB-256GBSSD", 6550.0);
        Product product4 = new Product("HP 14S-FQ0011NT", "CORE I5 8GB RAM", 6550.0);
        Product product5 = new Product("HP 250 G7", "PANDA A50", 6550.0);
        Product product6 = new Product("LENOVO IDEAPAD", "MD RYZEN", 6550.0);
        Product product7 = new Product("LENOVO TABM10", "FLEX 5 CORE I5", 6550.0);
        Product product8 = new Product("MSI GE76,", " RAIDER CORE I7", 6550.0);
        Product product9 = new Product("IPAD-32GB 8.NESIL", "SM-T500NZAATUR GRI", 6550.0);
        Product product10 = new Product("SAMSUNG GALAXY TAB A7", "LITE SM GRI", 6550.0);

        //add
        products.insert(product1);
        products.insert(product2);
        products.insert(product3);
        products.insert(product4);
        products.insert(product5);
        products.insert(product6);
        products.insert(product7);
        products.insert(product8);
        products.insert(product9);
        products.insert(product10);

        //display
        products.display();

        //search
        products.search("LENOVO TABM10");
        products.search("Mertcan's computer");

        System.out.println("DELETE");
        //delete
        products.delete("ASUS X415JA");
        products.delete("SAMSUNG GALAXY TAB A7");
        products.delete("Mertcan's computer");

        //display
        products.display();



    }
}
