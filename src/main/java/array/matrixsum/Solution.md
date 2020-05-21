
### Problem:

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

![https://leetcode.com/static/images/courses/range_sum_query_2d.png](https://leetcode.com/static/images/courses/range_sum_query_2d.png)

The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

### Link:

[https://leetcode.com/problems/range-sum-query-2d-immutable/](https://leetcode.com/problems/range-sum-query-2d-immutable/) 

 Example:

```jsx

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
```

**Note:**

1. You may assume that the matrix does not change.
2. There are many calls to  function.

    sumRegion

3. You may assume that row1 ≤ row2 and col1 ≤ col2.

### Solution:

### **Approach #1 (Brute Force) [Time Limit Exceeded]**

**Algorithm**

Each time *sumRegion* is called, we use a double for loop to sum all elements from (row1, col1) \rightarrow (row2, col2)(*row*1,*col*1)→(*row*2,*col*2).

```java

private int[][] data;

public NumMatrix(int[][] matrix) {
    data = matrix;
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int r = row1; r <= row2; r++) {
        for (int c = col1; c <= col2; c++) {
            sum += data[r][c];
        }
    }
    return sum;
}
        
```

**Complexity analysis**

- Time complexity : O(mn)*O*(*mn*) time per query. Assume that m*m* and n*n* represents the number of rows and columns respectively, each *sumRegion* query can go through at most m \times n*m*×*n* elements.
- Space complexity : O(1)*O*(1). Note that `data` is a *reference* to `matrix` and is not a copy of it.

### **Approach #2 (Caching) [Memory Limit Exceeded]**

**Intuition**

Since *sumRegion* could be called many times, we definitely need to do some pre-processing.

**Algorithm**

We could trade in extra space for speed by pre-calculating all possible rectangular region sum and store them in a hash table. Each *sumRegion* query now takes only constant time complexity.

**Complexity analysis**

- Time complexity : O(1)*O*(1) time per query, O(m^2n^2)*O*(*m*2*n*2) time pre-computation. Each *sumRegion* query takes O(1)*O*(1) time as the hash table lookup's time complexity is constant. The pre-computation will take O(m^2n^2)*O*(*m*2*n*2) time as there are a total of m^2 \times n^2*m*2×*n*2 possibilities need to be cached.
- Space complexity : O(m^2n^2)*O*(*m*2*n*2). Since there are mn*mn* different possibilities for both top left and bottom right points of the rectangular region, the extra space required is O(m^2n^2)*O*(*m*2*n*2).

### **Approach #3 (Caching Rows) [Accepted]**

**Intuition**

Remember from the [1D version](https://leetcode.com/course/chapters/leetcode-101/range-sum-query-immutable/) where we used a cumulative sum array? Could we apply that directly to solve this 2D version?

**Algorithm**

Try to see the 2D matrix as m*m* rows of 1D arrays. To find the region sum, we just accumulate the sum in the region row by row.

```java
private int[][] dp;

public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return;
    dp = new int[matrix.length][matrix[0].length + 1];
    for (int r = 0; r < matrix.length; r++) {
        for (int c = 0; c < matrix[0].length; c++) {
            dp[r][c + 1] = dp[r][c] + matrix[r][c];
        }
    }
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int row = row1; row <= row2; row++) {
        sum += dp[row][col2 + 1] - dp[row][col1];
    }
    return sum;
}
```

**Complexity analysis**

- Time complexity : O(m)*O*(*m*) time per query, O(mn)*O*(*mn*) time pre-computation. The pre-computation in the constructor takes O(mn)*O*(*mn*) time. The *sumRegion* query takes O(m)*O*(*m*) time.
- Space complexity : O(mn)*O*(*mn*). The algorithm uses O(mn)*O*(*mn*) space to store the cumulative sum of all rows.

### **Approach #4 (Caching Smarter) [Accepted]**

**Algorithm**

We used a cumulative sum array in the [1D version](https://leetcode.com/course/chapters/leetcode-101/range-sum-query-immutable/). We notice that the cumulative sum is computed with respect to the origin at index 0. Extending this analogy to the 2D case, we could pre-compute a cumulative region sum with respect to the origin at (0, 0)(0,0).

![https://leetcode.com/static/images/courses/sum_od.png](https://leetcode.com/static/images/courses/sum_od.png)

Sum(OD) is the cumulative region sum with respect to the origin at (0, 0).

How do we derive Sum(ABCD)*Sum*(*ABCD*) using the pre-computed cumulative region sum?

![https://leetcode.com/static/images/courses/sum_ob.png](https://leetcode.com/static/images/courses/sum_ob.png)

Sum(OB) is the cumulative region sum on top of the rectangle.

![https://leetcode.com/static/images/courses/sum_oc.png](https://leetcode.com/static/images/courses/sum_oc.png)

Sum(OC) is the cumulative region sum to the left of the rectangle.

![https://leetcode.com/static/images/courses/sum_oa.png](https://leetcode.com/static/images/courses/sum_oa.png)

Sum(OA) is the cumulative region sum to the top left corner of the rectangle.

Note that the region Sum(OA)*Sum*(*OA*) is covered twice by both Sum(OB)*Sum*(*OB*) and Sum(OC)*Sum*(*OC*). We could use the principle of inclusion-exclusion to calculate Sum(ABCD)*Sum*(*ABCD*) as following:

Sum(ABCD) = Sum(OD) - Sum(OB) - Sum(OC) + Sum(OA)*Sum*(*ABCD*)=*Sum*(*OD*)−*Sum*(*OB*)−*Sum*(*OC*)+*Sum*(*OA*)

```java
public NumMatrix(int[][] matrix) {
        this.mat = matrix;
        this.preComputeSum();
    }
    
    private void preComputeSum() {
        
        if (mat.length == 0 || mat[0].length == 0) return;
       
        sumMatrix = new int[mat.length][mat[0].length];

        //initialize sum matrix
        sumMatrix[0][0] = mat[0][0];

        //scan first row
        for (int i = 1; i < mat.length; i++) {
            sumMatrix[i][0] = sumMatrix[i-1][0] + mat[i][0];
        }

        //scan first column
        for (int j = 1; j < mat[0].length; j++) {
            sumMatrix[0][j] = sumMatrix[0][j-1] + mat[0][j];
        }

        //scan all the elements from 2nd row and 2nd column onwards
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] + mat[i][j] - sumMatrix[i-1][j-1]; // memoize the sum
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int OA, OB, OC, OD;
        if(row1 == 0 || col1 == 0)
            OA = 0;
        else
            OA = this.sumMatrix[row1 - 1][col1 - 1];

        if(row1 == 0)
            OB = 0;
        else
            OB = this.sumMatrix[row1 - 1][col2];

        if(col1 == 0)
            OC = 0;
        else
            OC = this.sumMatrix[row2][col1-1];

        OD = this.sumMatrix[row2][col2];
        return OD - OC - OB + OA;
    }
```

**Complexity analysis**

- Time complexity : O(1)*O*(1) time per query, O(mn)*O*(*mn*) time pre-computation. The pre-computation in the constructor takes O(mn)*O*(*mn*) time. Each *sumRegion* query takes O(1)*O*(1) time.
- Space complexity : O(mn)*O*(*mn*). The algorithm uses O(mn)*O*(*mn*) space to store the cumulative region sum.