package datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

public class QueueTest {

    @Test
    public void shouldQueueElements() {
        Queue<Integer> queue = new Queue<>();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        Assert.assertEquals(3, queue.size());
    }

    @Test
    public void shouldDequeElements() {
        Queue<Integer> queue = new Queue<>();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        Assert.assertEquals(Integer.valueOf(1), queue.deque());
        Assert.assertEquals(Integer.valueOf(2), queue.deque());
        Assert.assertEquals(Integer.valueOf(3), queue.deque());
        Assert.assertEquals(0, queue.size());
    }

    @Test
    public void shouldReturnPeekElement() {
        Queue<Integer> queue = new Queue<>();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        Assert.assertEquals(Integer.valueOf(1), queue.peek());
    }

    @Test(expected = EmptyStackException.class)
    public void dequeShouldThrowExceptionWhenQueueIsEmpty() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.deque();
        queue.deque();
        queue.deque();
        queue.deque();
    }

    @Test
    public void shouldReturnTrueIfQueueIsEmpty() {
        Queue queue = new Queue();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldReturnFalseIfQueueIsNotEmpty() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enque(11);
        queue.enque(12);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void shouldCreateQueueOfString() {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enque("Hello");
        stringQueue.enque("World");
        stringQueue.enque("Welcome!!");
        Assert.assertEquals(3, stringQueue.size());
        Assert.assertEquals("Hello", stringQueue.peek());
        Assert.assertEquals("Hello", stringQueue.deque());
        Assert.assertEquals("World", stringQueue.deque());
        Assert.assertEquals("Welcome!!", stringQueue.deque());
    }
}