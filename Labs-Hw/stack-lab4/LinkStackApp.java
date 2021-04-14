package lab4_stack_assignment;

import java.util.Scanner;

/*
    Name Surname: Mertcan Kose
    Student Num:18050111061
*/

class Link {
    public char dData;
    public Link next;

    public Link(char dd) {
        this.dData = dd;
    }
    public void displayLink() {
        System.out.print(dData + " ");
    }
}

class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }
    
    public boolean isEmpty() {
        return (first == null);
    }
    
    public void insertFirst(char dd) {
        Link newLink = new Link(dd); //node
        newLink.next = first;
        first = newLink;
    }
    
    public char deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp.dData; //deleting item data
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
    
    public char returnLast() {
        return first.dData;
    }
}

class LinkStack {

    private LinkList theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(char j) {
        theList.insertFirst(j);
    }

    public char pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return (theList.isEmpty());
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
    public char returnLast() {
        return theList.returnLast();
    }
}

public class LinkStackApp {
    
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a command to check");
        
        String command = scanner.nextLine();

        //Stack
        LinkStack theStack = new LinkStack();
        
        char symbol;
        for(int i = 0; i < command.length(); i++) {
            symbol = command.charAt(i);
            if(symbol == '(' || symbol == ')') {
                theStack.push(symbol);
            }
        }
        
        char paranthesis;
        int numberOfOpenParanthesis = 0;
        int numberOfCloseParanthesis = 0;
        
        while(!theStack.isEmpty()) {
            paranthesis = theStack.pop();
            if(paranthesis == '(') {
                numberOfOpenParanthesis++;
            } else if(paranthesis == ')') {
                numberOfCloseParanthesis++;
            }
        }
        
        if(numberOfOpenParanthesis < numberOfCloseParanthesis) {
            System.out.println("Status: Openin braket is missing!");
        } else if(numberOfOpenParanthesis > numberOfCloseParanthesis){
            System.out.println("Status: Closing braket is missing!");
        } else {
            System.out.println("Status: ACCEPTED");
        }
    }
}



