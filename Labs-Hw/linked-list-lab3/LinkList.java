package com.company;

public class LinkList {

    public LinkListNode head;
    public LinkListNode tail;

    public LinkList() {
        this.head = null;
        this.tail = null;
    }

    // Complete the printLinkedList function below.
    public void printLinkList(LinkListNode head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("\n");
    }

    // Complete the insertToHead function below.
    public void insertToHead(String nodeData){
        LinkListNode node = new LinkListNode(nodeData);
        node.next = this.head;
        this.head = node;
    }

    // Complete the insertToSpecificPosition function below.
    // Indexes are starting from 0.
    public void insertToSpecificPosition(String nodeData, int position){
        if(position == 1) {
            LinkListNode node = new LinkListNode(nodeData);
            node.next = this.head;
            this.head = node;
        } else {
            this.tail = this.head;
            int count = 1;
            while(this.tail.next != null) {
                count++;
                this.tail = this.tail.next;
            }
            this.tail = this.head;
            for(int i = 2; i <= count + 1 ; i++) {
                if(i == position) {
                    LinkListNode node = new LinkListNode(nodeData);
                    node.next = this.tail.next;
                    this.tail.next = node;
                    return;
                }
                this.tail = this.tail.next;
            }
            System.out.println("Invalid Position");
        }
    }

    // Complete the reversedPrintLinkList function below.
    // Do not use other data structures like arrays.
    public void reversedPrintLinkList(LinkListNode head) {
       LinkList list = new LinkList();

       while(head != null) {
           list.insertToHead(head.data);
           head = head.next;
       }

       while(list.head != null) {
           System.out.print(list.head.data + " ");
           list.head = list.head.next;
       }
       System.out.println("\n");
    }

    // Complete the sortedInsert function below which inserts items alphabetically sorted.
    public void sortedInsert(String nodeData) {
        //create link list
        if(this.head == null) {
            LinkListNode node = new LinkListNode(nodeData);
            this.head = node;
        }
        //add first
        else if(this.head.data.compareTo(nodeData) > 0) {
            LinkListNode node = new LinkListNode(nodeData);
            node.next = this.head;
            this.head = node;

        }
        //add anywhere except first
        else {
            this.tail = this.head;
            while(this.tail.next != null && this.tail.next.data.compareTo(nodeData) < 0) {
                tail = tail.next;
            }
            LinkListNode node = new LinkListNode(nodeData);
            node.next = this.tail.next;
            this.tail.next = node;
        }
    }
}