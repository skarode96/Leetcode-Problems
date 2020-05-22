package array.turbulent;

import org.junit.Assert;
import org.junit.Test;

public class LargestTurbulentArrayTest {
    @Test
    public void findLargestTurbulentArrayLength1() {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        int largestTurbulentArrayLength = LargestTurbulentArray.findLargestTurbulentArrayLength(arr);
        Assert.assertEquals(5, largestTurbulentArrayLength);
    }

    @Test
    public void findLargestTurbulentArrayLength2() {
        int[] arr = {1};
        int largestTurbulentArrayLength = LargestTurbulentArray.findLargestTurbulentArrayLength(arr);
        Assert.assertEquals(0, largestTurbulentArrayLength);
    }

    @Test
    public void findLargestTurbulentArrayLength3() {
        int[] arr = {0};
        int largestTurbulentArrayLength = LargestTurbulentArray.findLargestTurbulentArrayLength(arr);
        Assert.assertEquals(0, largestTurbulentArrayLength);
    }

    @Test
    public void findLargestTurbulentArrayLength4() {
        int[] arr = {4,8,12,16};
        int largestTurbulentArrayLength = LargestTurbulentArray.findLargestTurbulentArrayLength(arr);
        Assert.assertEquals(0, largestTurbulentArrayLength);
    }

    @Test
    public void findLargestTurbulentArrayLength5() {
        int[] arr = {100,100,100};
        int largestTurbulentArrayLength = LargestTurbulentArray.findLargestTurbulentArrayLength(arr);
        Assert.assertEquals(0, largestTurbulentArrayLength);
    }

}