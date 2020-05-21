package array.maxsubarray;

import org.junit.Assert;
import org.junit.Test;

public class MaxSubArrayTest {

    @Test
    public void testMaxSubArrayByNaiveApproach() {
        int[] nums = {1,2,3,4};
        int result = MaxSubArray.maxSubArrayNaiveApproach(nums);
        Assert.assertEquals(10, result);
    }

    @Test
    public void testMaxSubArrayByNaiveApproach1() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = MaxSubArray.maxSubArrayNaiveApproach(nums);
        Assert.assertEquals(6, result);
    }

    @Test
    public void testMaxSubArrayByNaiveApproach2() {
        int[] nums = {-1};
        int result = MaxSubArray.maxSubArrayNaiveApproach(nums);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testMaxSubArrayByNaiveApproach3() {
        int[] nums = {1};
        int result = MaxSubArray.maxSubArrayNaiveApproach(nums);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testMaxSubArrayByONApproach() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = MaxSubArray.maxSubArraySumByONapproach(nums);
        Assert.assertEquals(6, result);
    }

    @Test
    public void testMaxSubArrayByONApproach1() {
        int[] nums = {-1};
        int result = MaxSubArray.maxSubArraySumByONapproach(nums);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testMaxSubArrayByONApproach2() {
        int[] nums = {1};
        int result = MaxSubArray.maxSubArraySumByONapproach(nums);
        Assert.assertEquals(1, result);
    }

}