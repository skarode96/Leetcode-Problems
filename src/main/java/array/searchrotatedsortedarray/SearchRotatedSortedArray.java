package array.searchrotatedsortedarray;

public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {

        if(nums.length == 0)
            return 0;

        // divide the array in two parts

        int mid = 0;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            mid = (start + end) / 2;

            if( nums[mid] == target)
                return mid;


            if(nums[mid] <= nums[end]) {
                //upperhalf is sorted and element is present
               //if target is in lower half do binary search
                if(target >= nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;

            } else {
                //lowerhalf is sorted and element is present
                if(target >= nums[start] && target <= nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

        }
        return -1;
    }


}
