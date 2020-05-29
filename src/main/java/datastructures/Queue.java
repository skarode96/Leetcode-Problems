package datastructures;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Queue<T> {

    private List<T> queue;

    public Queue() {
        this.queue = new ArrayList<>();
    }

    public void enque(T element) {
        this.queue.add(element);
    }

    public T deque() {
        if(this.queue.size() > 0)
            return this.queue.remove(0);
        else
            throw new EmptyStackException();
    }

    public T peek() {
        return this.queue.get(0);
    }


    public int size() {
        return this.queue.size();
    }

    public boolean isEmpty() {
        return this.queue.size() == 0;
    }
}
