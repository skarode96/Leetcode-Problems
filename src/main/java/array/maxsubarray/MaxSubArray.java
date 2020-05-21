package array.maxsubarray;

public class MaxSubArray {

    public static int maxSubArrayNaiveApproach(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if(sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    public static int maxSubArraySumByONapproach(int[] nums) {
        int maxSum = nums[0] , currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Integer.max(currSum+nums[i], nums[i]);
            maxSum = Integer.max(currSum, maxSum);
        }
        return maxSum;
    }
}
