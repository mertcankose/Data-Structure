/*
Name-Surname: Mertcan Kose
Id: 18050111061
*/

package hw1_datastructure;

public class Node<E> {
    E value;
    Node next;
    
    public Node(E num) {
        this.value = num;
        this.next = null;
    }
}