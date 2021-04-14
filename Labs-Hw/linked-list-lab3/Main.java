package com.company;

public class Main {
    public static void main(String[] args) {
        LinkList myLinkList = new LinkList();

        // Add 5 item with sortedInsert
        myLinkList.sortedInsert("Mertcan");
        myLinkList.sortedInsert("Angela");
        myLinkList.sortedInsert("John");
        myLinkList.sortedInsert("Caroline");
        myLinkList.sortedInsert("Ted");

        // Display them with printLinkList.
        System.out.println("Print Linked List");
        myLinkList.printLinkList(myLinkList.head);

        // Display reversedPrintLinkList.
        System.out.println("Reversed Print Linked List");
        myLinkList.reversedPrintLinkList(myLinkList.head);

        // Use insertToHead with 2 item
        myLinkList.insertToHead("Alameda");
        myLinkList.insertToHead("Zack");

        // Display with printLinkList.
        System.out.println("Print Linked List");
        myLinkList.printLinkList(myLinkList.head);


        // Use insertToSpecificPosition with 2 item
        myLinkList.insertToSpecificPosition("Frank", 2);
        myLinkList.insertToSpecificPosition("Brad", 1);
        myLinkList.insertToSpecificPosition("Alice", 8);

        // Display with printLinkList.
        System.out.println("Print Linked List");
        myLinkList.printLinkList(myLinkList.head);

        // Display reversedPrintLinkList.
        System.out.println("Reversed Print Linked List");
        myLinkList.reversedPrintLinkList(myLinkList.head);
    }
}
