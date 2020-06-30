package datastructures.competitiveprogramming;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.add(400);
        pQueue.add(10);
        pQueue.add(30);
        pQueue.add(20);


        System.out.println("Head value using peek function:" + pQueue.peek());

        // Printing all elements
        System.out.println("The queue elements:");

        printElements(pQueue);

        pQueue.poll();
        System.out.println("After removing an element "
                + "with poll function:");
        printElements(pQueue);

        // Removing 30 using remove()
        pQueue.remove(30);
        System.out.println("after removing 30 with"
                + " remove function:");
        printElements(pQueue);

        // Check if an element is present using contains()
        boolean b = pQueue.contains(20);
        System.out.println("Priority queue contains 20 "
                + "or not?: " + b);

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] arr = pQueue.toArray();
        System.out.println("Value in array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.println("Value: " + arr[i].toString());
    }

    private static void printElements(PriorityQueue pQueue) {
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}
