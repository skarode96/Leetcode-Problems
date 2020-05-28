package sortingalgo;

import org.junit.Assert;
import org.junit.Test;

public class RadixSortTest {

    @Test
    public void shouldHandleEmptyArray() {
        int[] arr = {};
        int[] sortedArray = RadixSort.sort(arr);
        Assert.assertEquals(0, sortedArray.length);
    }

    @Test public void shouldSortArray() {
        int[] arr = {5,800,1112,3,622,9,1};
        int[] sortedArray = RadixSort.sort(arr);
        Assert.assertEquals(sortedArray[0], 1);
        Assert.assertEquals(sortedArray[1], 3);
        Assert.assertEquals(sortedArray[2], 5);
        Assert.assertEquals(sortedArray[3], 9);
        Assert.assertEquals(sortedArray[4], 622);
        Assert.assertEquals(sortedArray[5], 800);
        Assert.assertEquals(sortedArray[6], 1112);
    }

}