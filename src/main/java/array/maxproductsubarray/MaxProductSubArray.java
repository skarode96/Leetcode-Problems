package array.maxproductsubarray;

public class MaxProductSubArray {
    public static int maxProductSubArrayNaiveApproach(int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentProduct = nums[i];
            maxProduct = Integer.max(currentProduct, maxProduct);
            for (int j = i+1; j < nums.length; j++) {
                currentProduct = currentProduct*nums[j];
                maxProduct = Integer.max(currentProduct, maxProduct);
            }
        }
        return maxProduct;
    }

    public static int maxProductSubArrayOnApproach(int[] nums) {

        if(nums.length == 0)
            return 0;

        int maxProduct = Integer.MIN_VALUE;

        int currentProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            currentProduct = currentProduct* nums[i];
            maxProduct = Math.max(currentProduct, maxProduct);
            if(currentProduct == 0) {
               currentProduct =1;
            }
        }

        currentProduct = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            currentProduct = currentProduct* nums[i];
            maxProduct = Math.max(currentProduct, maxProduct);
            if(currentProduct == 0) {
                currentProduct = 1;
            }
        }

        return maxProduct;
    }
}
