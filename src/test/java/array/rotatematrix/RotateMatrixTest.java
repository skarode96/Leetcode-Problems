package array.rotatematrix;

import org.junit.Assert;
import org.junit.Test;

public class RotateMatrixTest {

    @Test
    public void shouldRotateMatrix() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix.rotate(matrix);
        Assert.assertEquals(7, matrix[0][0]);
        Assert.assertEquals(4, matrix[0][1]);
        Assert.assertEquals(1, matrix[0][2]);
        Assert.assertEquals(8, matrix[1][0]);
        Assert.assertEquals(5, matrix[1][1]);
        Assert.assertEquals(2, matrix[1][2]);
        Assert.assertEquals(9, matrix[2][0]);
        Assert.assertEquals(6, matrix[2][1]);
        Assert.assertEquals(3, matrix[2][2]);

    }

    @Test
    public void shouldMirrorMatrix() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix.mirrorRows(matrix);
        Assert.assertEquals(7, matrix[0][0]);
        Assert.assertEquals(8, matrix[0][1]);
        Assert.assertEquals(9, matrix[0][2]);
        Assert.assertEquals(4, matrix[1][0]);
        Assert.assertEquals(5, matrix[1][1]);
        Assert.assertEquals(6, matrix[1][2]);
        Assert.assertEquals(1, matrix[2][0]);
        Assert.assertEquals(2, matrix[2][1]);
        Assert.assertEquals(3, matrix[2][2]);
    }

    @Test
    public void shouldSwapLowerTriangularMatrix() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RotateMatrix.swapLowerTriangular(matrix);
        Assert.assertEquals(1, matrix[0][0]);
        Assert.assertEquals(4, matrix[0][1]);
        Assert.assertEquals(7, matrix[0][2]);
        Assert.assertEquals(2, matrix[1][0]);
        Assert.assertEquals(5, matrix[1][1]);
        Assert.assertEquals(8, matrix[1][2]);
        Assert.assertEquals(3, matrix[2][0]);
        Assert.assertEquals(6, matrix[2][1]);
        Assert.assertEquals(9, matrix[2][2]);
    }
}