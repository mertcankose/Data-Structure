/*
Name-Surname: Mertcan Kose
Id: 18050111061
*/

package hw1_datastructure;

public class MyQueue <E> {
    Node front, rear;
    
    public MyQueue() {
        this.front = null;
        this.rear = null;
    }
    
    public void push(E x) {
        Node node = new Node<>(x);
        if(this.front == null) { 
            this.front = node;
            this.rear = node;
        }else {
            
            node.next = this.front;
            this.front = node;
        }
    }
    
    public Object pop() {
        if(this.front == null) {
            return -1;
        }
        E rvalue = (E) this.front.value;
        this.front = this.front.next;
        return rvalue;
    }
    
    //Insert item x on the rear end of the deque
    public void inject(E x) {
        Node node = new Node(x);
        if(this.front == null) { 
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;

        }
    }
    
    public Object eject() {
        if(this.rear == null) {
            return -1;
        }
        if(this.front.next == null) {
            E rvalue = (E) this.front.value;
            this.front = null;
            this.rear = null;
            return rvalue;
        }

        Node temp = front;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        E rvalue = (E) this.rear.value;
        this.rear = temp;
        temp.next = null;
        
        return rvalue;
    }
}
