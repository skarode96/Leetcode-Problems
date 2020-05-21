# Two Pair Sum problem

### Problem:

Given an array of integers, return indices of the two numbers such that they add up to a specific target. You may assume that each input would have exactly one solution, and you may not use the same element twice.

### Link:

[https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/) 

 Example:

```jsx

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

```

### Solution:

1. Naive approach would be to scan array using nested for loop and find a pair which matches
the target

```jsx

main:
    for i -> 1: len(arr)-1:
        for j -> i+1 : len(arr):
            if arr[i] + arr[j] == target:
                return [arr[i], arr[j]];
            else
                throw("pair not found exception")
        
```

2. The above solution is O(N^2) which can be further optimized to O(N*logN) by
sorting array first which takes O(N*logN) time and finding pair in O(N) time. So the overall complexity would be O(N*logN)

```jsx
main:
    sort(arr);
    start_index = arr[0]
    last_index = arr[len]
    while (start_index < last_index) : 
	if( arr[start_index] + arr[last_index] == target):
		return pair of int
	start_index++;
	last_index++;
    throw("pair not found exception")
```

3. Alternatively, we can use Hashmap to keep a track of already visited element and its index

 we keep on adding the elements till we receive an element whose sum equals to target

```jsx
main:
    map = Hashmap<int,int>
    i  = 1
    map.add(arr[0], 0)
    while ( i < len[arr]) : 
        if( map contains target-arr[i]):
            return pair of int (map.get(target-arr[i]), i)
        map.put(arr[i], i)
        i++
    throw("pair not found exception")
```
