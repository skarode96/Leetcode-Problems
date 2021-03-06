package datastructures;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {

    private ArrayList<T> content;
    private int stackPointer = 0;

    public Stack() {
        this.content = new ArrayList<>();
    }

    public int size() {
        return this.content.size();
    }

    public void push(T entry) {
        this.content.add(entry);
        this.stackPointer++;
    }

    public T pop() throws IllegalStateException {
        if(stackPointer <= 0)
            throw new EmptyStackException();
        return this.content.remove(--stackPointer);
    }

    public boolean isEmpty() {
        return this.stackPointer == 0;
    }
}
