package datastructures.competitiveprogramming;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        System.out.printf("Deque Item %s should be 1 \n", integerQueue.remove());
        System.out.printf("Deque Item %s should be 2 \n", integerQueue.remove());
        System.out.printf("Peek Item %s should be 3 \n", integerQueue.peek());
        System.out.printf("Is Queue Empty %s should be false \n", integerQueue.isEmpty());
        System.out.printf("Queue size %s should be 1 \n", integerQueue.size());
    }
}
