package datastructures.competitiveprogramming;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(3);
        integerStack.push(2);
        integerStack.push(4);
        System.out.printf("Popped Item %s should be 4 \n", integerStack.pop());
        System.out.printf("Popped Item %s should be 2 \n", integerStack.pop());
        System.out.printf("Peek Item %s should be 3 \n", integerStack.peek());
        System.out.printf("Is Stack Empty %s should be false \n", integerStack.empty());
    }
}
