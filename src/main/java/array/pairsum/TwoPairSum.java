package array.pairsum;

import java.util.HashMap;

public class TwoPairSum {
    public static int[] twoSum(int[]
                                       nums, int target) {
        //map of number and index
        HashMap<Integer, Integer> map = new HashMap<>();

        //initialize map with first entry of array
        int[] resultPair = {0,0};
        map.put(nums[0], 0);
        int index = 1;

        while (index < nums.length) {

            int complement = target - nums[index];
            if(map.containsKey(complement)) {
                resultPair[0] = map.get(complement);
                resultPair[1] = index;
            }

            map.put(nums[index], index);
            index++;
        }
        return resultPair;
    }
}
