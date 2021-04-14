package com.company;

public class ProductArray {
    private Product[] myArray;
    private int count;

    public ProductArray(int size) {
        myArray = new Product[size];
        count = 0;
    }

    public void search(String productName) {
        for(int i = 0;i<count;i++) {
            if(myArray[i].getName() == productName) {
                myArray[i].displayProduct();
            }
        }
    }

    public void insert(Product product) {
        if(count == myArray.length) {
            Product[] myArray2 = new Product[count * 2];
            for(int i = 0; i<count; i++) {
                myArray2[i] = myArray[i];
            }
            myArray = myArray2;
        }
        myArray[count++] = product;
    }

    public void delete(String productName) {
        if(productName.length() == 0) {
            throw new IllegalArgumentException("Error!");
        }
        //shifting to left
        for(int i = 0; i<count;i++) {
            if(myArray[i].getName() == productName) {
                for(int j = i; j<count; j++) {
                    myArray[j] = myArray[j + 1];
                }
                count--;
            }
        }

    }

    public void display() {
        for(int i = 0;i<count;i++) {
            System.out.println(myArray[i].getName());
        }
    }

}
