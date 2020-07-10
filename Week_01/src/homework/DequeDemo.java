package homework;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {

        Deque<String> dequeFirst = new LinkedList<String>();
        // addFirst
        dequeFirst.addFirst("A");
        dequeFirst.addFirst("B");
        dequeFirst.addFirst("C");
        System.out.println("deque addFirst A,B,C = " + dequeFirst);
        // addLast
        dequeFirst.addLast("X");
        dequeFirst.addLast("Y");
        dequeFirst.addLast("Z");
        System.out.println("deque addLast X,Y,Z = " + dequeFirst);
        // offerFirst
        dequeFirst.offerFirst("D");
        dequeFirst.offerFirst("E");
        dequeFirst.offerFirst("F");
        System.out.println("deque offerFirst D,E,F = " + dequeFirst);
        // offerLast
        dequeFirst.offerLast("This");
        dequeFirst.offerLast("is");
        dequeFirst.offerLast("offerLast");
        System.out.println("deque offerLast 3 elements = " + dequeFirst);

        Deque<String> dequeSecond = new LinkedList<String>();
        // addLast
        dequeSecond.addLast("addLast1");
        dequeSecond.addLast("addLast2");
        dequeSecond.addLast("addLast3");
        System.out.println("dequeSecond addLast 3 element = " + dequeSecond);

        // peekFirst()
        String peekFirst = dequeSecond.peekFirst();
        System.out.println("dequeSecond.peekFirst = " + peekFirst);
        System.out.println("dequeSecond = " + dequeSecond);

        // peekLast()
        String peekLast = dequeSecond.peekLast();
        System.out.println("dequeSecond.peekLast = " + peekLast);
        System.out.println("dequeSecond = " + dequeSecond);

        // pollFirst()
        while(!dequeSecond.isEmpty()){
            System.out.println("dequeSecond.pollFirst() = " + dequeSecond.pollFirst());
        }
        System.out.println("dequeSecond = " + dequeSecond);
        
        // pollLast()
        while(!dequeFirst.isEmpty()){
            System.out.println("dequeFirst.pollLast() = " + dequeFirst.pollLast());
        }
        System.out.println("dequeFirst = " + dequeFirst);

    }
}