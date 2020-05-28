package datastructures;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {

    @Test
    public void shouldReturnSizeOfStack() {
        Stack stack = new Stack();
        Assert.assertEquals(0, stack.size());
    }

    @Test
    public void shouldPushElementsInStack() {
        Stack<Integer> stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertEquals(3, stack.size());
    }

    @Test
    public void shouldPopElementsInStack() {
        Stack<Integer> stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
    }

    @Test
    public void shouldReturnTrueIfStackIsEmpty() {
        Stack stack = new Stack();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void shouldReturnFalseIfStackIsNotEmpty() {
        Stack<Integer> stack = new Stack();
        stack.push(2);
        stack.push(3);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void shouldCreateStackOfStringElements() {
        Stack<String> stack = new Stack<>();
        stack.push("Test1");
        stack.push("Test2");
        stack.push("Test3");
        Assert.assertEquals("Test3", stack.pop());
        Assert.assertEquals("Test2", stack.pop());
        Assert.assertEquals(1, stack.size());
    }

    @Test
    public void shouldThrowExceptionIfStackIsEmpty() {
        Stack<String> stack = new Stack<>();
        stack.push("Test1");
        stack.pop();
        Exception exception = assertThrows(IllegalStateException.class, stack::pop);

        String expectedMessage = "Cannot perform pop";
        String actualMessage = exception.getMessage();
        Assert.assertEquals(expectedMessage, actualMessage);

    }

}