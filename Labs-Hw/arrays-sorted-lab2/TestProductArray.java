package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestProductArray {

    public static void main(String[] args) {
        ProductArray productArray1 = new ProductArray(3000);
        ProductArray productArray2 = new ProductArray(3000);
        ProductArray productArray3 = new ProductArray(3000);
        ProductArray productArray4 = new ProductArray(3000);

        try {
            File myObj = new File("C:\\Users\\mertc\\IdeaProjects\\lab1_datastructure\\src\\com\\company\\products.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                String productName = parts[0];
                String productDescription = parts[1];
                double productPrice = Double.parseDouble(parts[2]);

                productArray1.insert(new Product(productName, productDescription, productPrice));
                productArray2.insert(new Product(productName, productDescription, productPrice));
                productArray3.insert(new Product(productName, productDescription, productPrice));
                productArray4.sortedInsert(new Product(productName, productDescription, productPrice));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        productArray1.bubbleSort();
        productArray2.insertionSort();
        productArray3.selectionSort();


        System.out.println("Output for Products .txt file: ");

        System.out.println("BUBBLE SORT");
        System.out.println("Total Sort Operations: " + productArray1.getSortCost());
        System.out.println("-----------------------");

        System.out.println("INSERTION SORT");
        System.out.println("Total Sort Operations: " + productArray2.getSortCost());
        System.out.println("-----------------------");

        System.out.println("SELECTION SORT");
        System.out.println("Total Sort Operations: " + productArray3.getSortCost());
        System.out.println("-----------------------");

        System.out.println("SORTED INSERT");
        System.out.println("Total Sort Operations: " + productArray4.getSortCost());
        System.out.println("-----------------------");

        //

        ProductArray newProductArray1 = new ProductArray(30000);
        ProductArray newProductArray2 = new ProductArray(30000);
        ProductArray newProductArray3 = new ProductArray(30000);
        ProductArray newProductArray4 = new ProductArray(30000);

        try {
            File myObj = new File("C:\\Users\\mertc\\IdeaProjects\\lab1_datastructure\\src\\com\\company\\productList.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(",");
                String productName = parts[0];
                String productDescription = parts[1];
                double productPrice = Double.parseDouble(parts[2]);

                newProductArray1.insert(new Product(productName, productDescription, productPrice));
                newProductArray2.insert(new Product(productName, productDescription, productPrice));
                newProductArray3.insert(new Product(productName, productDescription, productPrice));
                newProductArray4.sortedInsert(new Product(productName, productDescription, productPrice));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        newProductArray1.bubbleSort();
        newProductArray2.insertionSort();
        newProductArray3.selectionSort();

        System.out.println("Output for ProductList.txt file: ");
        System.out.println("BUBBLE SORT");
        System.out.println("Total Sort Operations: " + newProductArray1.getSortCost());
        System.out.println("-----------------------");

        System.out.println("INSERTION SORT");
        System.out.println("Total Sort Operations: " + newProductArray2.getSortCost());
        System.out.println("-----------------------");

        System.out.println("SELECTION SORT");
        System.out.println("Total Sort Operations: " + newProductArray3.getSortCost());
        System.out.println("-----------------------");

        System.out.println("SORTED INSERT");
        System.out.println("Total Sort Operations: " + newProductArray4.getSortCost());
        System.out.println("-----------------------");

        System.out.println("Sroted Version");
        productArray1.display();

    }
}
