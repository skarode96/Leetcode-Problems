# Max Contiguous Sub Array Sum

### Problem:

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
### Link:

[https://leetcode.com/problems/maximum-subarray](https://leetcode.com/problems/maximum-subarray) 

 Example:

```jsx

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

```

### Solution:

1. Naive approach would be to scan array using nested for loop and keep on adding elements
Keep a track of max sum encountered

```jsx

main:
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
        
```

2. The above solution is O(N^2) which can be further optimized to O(N) by use of two variables, current sum and max sum
current sum keeps track of sum of the elements in greedy approach.
To calculate the solution for any element at index “i” has two options

EITHER add to the solution found till “i-1“th index
OR start a new sum from the index “i“.
    

```java
int maxSum = nums[0] , currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Integer.max(currSum+nums[i], nums[i]);
            maxSum = Integer.max(currSum, maxSum);
        }
        return maxSum;
```

