
/*
Name-Surname: Mertcan Kose
Id: 18050111061
*/

package hw1_datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MyDequeTester {
    public static void check(Object x, Object y) {
	if (x.equals(y)) 
	    System.out.println("Success!");
	 else 
	     System.out.println("********* Failure: value was "+x);
    }
    public static boolean check2(Object x, Object y) {
        if(x.equals(y)) {
            return true;
        }
        return false;
    }
    public static boolean isPunctuation(char c) {
        return c == ','
            || c == '.'
            || c == '!'
            || c == '?'
            || c == ':'
            || c == ';'
            || c == ' '
            || c == '\''
            || c == '-'
            ;
    }
    
    public static void main(String[] args) {
     
        System.out.println("Q1");
        
	Integer tmp;
	MyQueue<Integer> dq = new MyQueue<>();

	System.out.println("Pushing 100");
	dq.push(100);

	System.out.println("Pushing 150");
	dq.push(150);
	
	System.out.println("Pushing 200");
	dq.push(200);

	System.out.println("The deque is currently: "+dq);

	System.out.println("Popping... Should be 200");
	
	tmp = (Integer) dq.pop();
	check(tmp, 200);
	
	System.out.println("Ejecting... Should be 100");
	tmp = (Integer) dq.eject();
	check(tmp, 100);

	System.out.println("Injecting 1000");
	dq.inject(1000);
	
	System.out.println("Ejecting... should be 1000");
	tmp = (Integer) dq.eject();
	check(tmp, 1000);

	System.out.println("Ejecting... should be 150");
	tmp = (Integer) dq.eject();
	check(tmp, 150);
	
	// Begin stress testing

	for (int i=0; i<250000; i++) {
	    dq.push(i);
	    dq.inject(-i);
	}

	System.out.println("Stress testing complete. If that didn't take too "+
			   "long, your class is efficiently coded");
        
        
        System.out.println("-----");
        System.out.println("Q2");
        
        Character tmp2;
        Character tmp3;
	
        try {
          File myObj = new File("C:\\Users\\mertc\\Desktop\\DataStructures\\School\\hw-1\\palindromes.txt");
          Scanner myReader = new Scanner(myObj);
          
          while (myReader.hasNextLine()) {
              MyQueue<Character> dq2 = new MyQueue<>();
              String data = myReader.nextLine();
              for(int i = 0; i<data.length(); i++) {
                    char c = data.charAt(i);
                    if(!isPunctuation(c)) {
                        dq2.inject(c);
                    }    
              }
              Node temp2 = dq2.front;
              boolean flag = true;
              while(temp2.next != null) {
                tmp2 = (Character) dq2.pop();
                tmp3 = (Character) dq2.eject();
                flag = check2(tmp2, tmp3);
                
                temp2 = temp2.next;
              }
              if(flag){
                  System.out.println(data + " is a palindrome.\n");
              }else {
                  System.out.println(data + " is not a palindrome");
              }
          }
          myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }  
   }
}
