package array.maxproductsubarray;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductSubArrayTest {

    @Test
    public void shouldReturnMaxProductSubArray1(){
        int[] nums= {1,2,3,4,5,-6,7};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(120, actualProduct);
    }
    @Test
    public void shouldReturnMaxProductSubArray2(){
        int[] nums= {-2,0,-1};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(0, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray3(){
        int[] nums= {-2};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(-2, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray4(){
        int[] nums= {};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(0, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray5(){
        int[] nums= {1,2,-2,-3,4,5,-7};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(420, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray6(){
        int[] nums= {0,2};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(2, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray7(){
        int[] nums= {3,-1,4};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(4, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray8(){
        int[] nums= {-3,-1};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(3, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray9(){
        int[] nums= {-2, 1, 0};
        int actualProduct = MaxProductSubArray.maxProductSubArrayNaiveApproach(nums);
        Assert.assertEquals(1, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray10(){
        int[] nums= {1,2,3,4,5,-6,7};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(120, actualProduct);
    }
    @Test
    public void shouldReturnMaxProductSubArray11(){
        int[] nums= {-2,0,-1};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(0, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray12(){
        int[] nums= {-2};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(-2, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray13(){
        int[] nums= {};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(0, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray14(){
        int[] nums= {1,2,-2,-3,4,5,-7};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(420, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray15(){
        int[] nums= {0,2};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(2, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray16(){
        int[] nums= {3,-1,4};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(4, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray17(){
        int[] nums= {-3,-1};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(3, actualProduct);
    }

    @Test
    public void shouldReturnMaxProductSubArray18(){
        int[] nums= {-2, 1, 0};
        int actualProduct = MaxProductSubArray.maxProductSubArrayOnApproach(nums);
        Assert.assertEquals(1, actualProduct);
    }


}