package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {

    @Test
    public void shouldCreateHeapOfGivenSize() {
        MinHeap minHeap = new MinHeap(8);
        Assert.assertEquals(8, minHeap.size());
    }

    @Test
    public void shouldInsertElementToHeap() throws Exception {
        MinHeap minHeap = new MinHeap(8);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);
        Assert.assertEquals(4, minHeap.size());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfHeapIsFull() throws Exception {
        MinHeap minHeap = new MinHeap(2);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
    }

    @Test
    public void shouldPrintHeap() throws Exception {
        MinHeap minHeap = new MinHeap(8);
        minHeap.insert(5);
        minHeap.insert(11);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(19);
        minHeap.print();
    }

    @Test
    public void shouldRemoveElement() throws Exception {
        MinHeap minHeap = new MinHeap(8);
        minHeap.insert(5);
        minHeap.insert(11);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(19);
        minHeap.print();
        Assert.assertEquals(1, minHeap.remove());
        minHeap.print();
        Assert.assertEquals(2, minHeap.remove());
        minHeap.print();
        Assert.assertEquals(5, minHeap.remove());
        minHeap.print();
    }

    @Test
    public void shouldCheckAdditionOfElement() throws Exception {
        MinHeap minHeap = new MinHeap(8);
        System.out.println("adding 5");
        minHeap.insert(5);
        System.out.println("adding 11");
        minHeap.insert(11);
        minHeap.print();
        System.out.println("adding 10");
        minHeap.insert(10);
        minHeap.print();
        System.out.println("removing 5");
        minHeap.remove();
        minHeap.print();
        System.out.println("adding 5");
        minHeap.insert(5);
        minHeap.print();
    }

    @Test
    public void shouldRemoveWithGivenIndex() throws Exception {
        MinHeap minHeap = new MinHeap(8);
        minHeap.insert(5);
        minHeap.insert(11);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(19);
        minHeap.print();
        minHeap.remove(4);
        minHeap.print();
    }

    @Test
    public void shouldDeleteWithGivenElement() throws Exception {
        MinHeap minHeap = new MinHeap(8);
        minHeap.insert(5);
        minHeap.insert(11);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(19);
        minHeap.print();
        minHeap.delete(5);
        minHeap.print();
    }

}