package array.matrixsum;

import org.junit.Assert;
import org.junit.Test;

public class MatrixRegionSumTest {

    @Test
    public void testGetMatrixRegionSum() {
        int[][] matrix = {{1,2},{2,3}};
        MatrixRegionSum matrixRegionSum = new MatrixRegionSum(matrix);
        int actualSum = matrixRegionSum.getSumByNaiveApproach(0,0,1,1);
        Assert.assertEquals(8, actualSum);
    }

    @Test
    public void testGetMatrixRegionSum1() {
        int[][] matrix = {{3, 0, 1, 4, 2},
                          {5, 6, 3, 2, 1},
                          {1, 2, 0, 1, 5},
                          {4, 1, 0, 1, 7},
                          {1, 0, 3, 0, 5}};
        MatrixRegionSum matrixRegionSum = new MatrixRegionSum(matrix);
        int actualSum = matrixRegionSum.getSumByNaiveApproach(1, 1, 2, 2);
        Assert.assertEquals(11, actualSum);
    }

    @Test
    public void testGetMatrixRegionSum2() {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        MatrixRegionSum matrixRegionSum = new MatrixRegionSum(matrix);
        int actualSum = matrixRegionSum.getSumByNaiveApproach(1, 2, 2, 4);
        Assert.assertEquals(12, actualSum);
    }

    @Test
    public void testGetMatrixRegionSum3() {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        MatrixRegionSum matrixRegionSum = new MatrixRegionSum(matrix);
        int actualSum = matrixRegionSum.getSumByNaiveApproach(2, 1, 4, 3);
        Assert.assertEquals(8, actualSum);
    }

    @Test
    public void testGetMatrixRegionSumForOptimizedApproach() {
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        MatrixRegionSum matrixRegionSum = new MatrixRegionSum(matrix);
        matrixRegionSum.preComputeSum();
        int actualSum = matrixRegionSum.getSumByOptimizedApproach(2, 1, 4, 3);
        Assert.assertEquals(8, actualSum);
    }

    @Test
    public void calculateSumMatrix() {
        int[][] matrix = {{3, 0, 4}, {5, 6, 9}, {1,2,3}};
        MatrixRegionSum matrixRegionSum = new MatrixRegionSum(matrix);

        matrixRegionSum.preComputeSum();

        int[][] expectedMatrix = {{3, 3, 7},{8,14, 27},{9,17, 33}};
        Assert.assertEquals(expectedMatrix[0][0], matrixRegionSum.getSumMatrix()[0][0]);
        Assert.assertEquals(expectedMatrix[0][1], matrixRegionSum.getSumMatrix()[0][1]);
        Assert.assertEquals(expectedMatrix[0][2], matrixRegionSum.getSumMatrix()[0][2]);
        Assert.assertEquals(expectedMatrix[1][0], matrixRegionSum.getSumMatrix()[1][0]);
        Assert.assertEquals(expectedMatrix[1][1], matrixRegionSum.getSumMatrix()[1][1]);
        Assert.assertEquals(expectedMatrix[1][2], matrixRegionSum.getSumMatrix()[1][2]);
        Assert.assertEquals(expectedMatrix[2][0], matrixRegionSum.getSumMatrix()[2][0]);
        Assert.assertEquals(expectedMatrix[2][1], matrixRegionSum.getSumMatrix()[2][1]);
        Assert.assertEquals(expectedMatrix[2][2], matrixRegionSum.getSumMatrix()[2][2]);
    }

}