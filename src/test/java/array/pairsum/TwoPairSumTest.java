package array.pairsum;

import org.junit.Assert;
import org.junit.Test;

public class TwoPairSumTest {

    @Test
    public void testGetTwoPairSumCase0() throws Exception {
        int[] result = TwoPairSum.twoSum(new int[]{2, 3, 4, 5, 6, 7}, 6);
        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 2);
    }

    @Test
    public void testGetTwoPairCase1() throws Exception {
        int[] result = TwoPairSum.twoSum(new int[]{2, 3}, 5);
        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 1);
    }

    @Test
    public void testGetTwoPairCase2() throws Exception {
        int[] result = TwoPairSum.twoSum(new int[]{2}, 5);
        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 0);
    }

    @Test
    public void testGetTwoPairCase3() throws Exception {
        int[] result = TwoPairSum.twoSum(new int[]{2,3,4}, 10);
        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 0);
    }

}