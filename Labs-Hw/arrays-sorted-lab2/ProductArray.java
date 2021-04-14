package com.company;

public class ProductArray {
    private Product[] myArray;
    private int count;
    private int sortCost;

    public ProductArray(int size) {
        myArray = new Product[size];
        count = 0;
        sortCost = 0;
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

    public void sortedInsert(Product product) {
        for(int i = 0; i<count; i++) {
            if ( myArray[i].getName().compareTo( product.getName() ) < 0 ) {
                myArray[i] = product;
                sortCost++;
            }
        }
        myArray[count++] = product;
        sortCost++;
    }

    public void bubbleSort() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count-i-1; j++) {
                sortCost++;
                String firstName = myArray[j].getName();
                String secondName = myArray[j+1].getName();
                if (firstName.compareTo(secondName) > 0) {
                    Product temp = myArray[j];
                    sortCost++;
                    myArray[j] = myArray[j+1];
                    sortCost++;
                    myArray[j+1] = temp;
                    sortCost++;
                }
            }
            //System.out.println(myArray[j]);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < count; i++) {
            Product element = myArray[i];
            int j;
            for (j = i - 1; j >= 0; j--){
                sortCost++;
                if(element.getName().compareTo(myArray[j].getName()) < 0) {
                    myArray[j + 1] = myArray[j];
                }
            }
            myArray[j + 1] = element;
            sortCost++;
        }
    }

    public void selectionSort() {
        for ( int j=0; j < count; j++ ) {
            int min = j;
            for ( int k=j+1; k < count-1; k++ ){
                sortCost++;
                if ( myArray[k].getName().compareTo( myArray[min].getName() ) < 0 ){
                    min = k;
                }
            }
            Product temp = myArray[j];
            sortCost++;
            myArray[j] = myArray[min];
            sortCost++;
            myArray[min] = temp;
            sortCost++;
        }
    }

    public int getSortCost() {
        return this.sortCost;
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
            myArray[i].displayProduct();
        }
    }

}
