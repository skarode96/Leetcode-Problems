package sortingalgo;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void shouldHandleEmptyArray() {
        int[] arr = {};
        int[] sortedArray = MergeSort.sortArray(arr);
        Assert.assertEquals(0, sortedArray.length);
    }

    @Test public void shouldSortArray() {
        int[] arr = {5,8,1,3,6,9,1};
        int[] sortedArray = MergeSort.sortArray(arr);
        Assert.assertEquals(sortedArray[0], 1);
        Assert.assertEquals(sortedArray[1], 1);
        Assert.assertEquals(sortedArray[2], 3);
        Assert.assertEquals(sortedArray[3], 5);
        Assert.assertEquals(sortedArray[4], 6);
        Assert.assertEquals(sortedArray[5], 8);
        Assert.assertEquals(sortedArray[6], 9);
    }
}