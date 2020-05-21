package array.matrixsum;

public class MatrixRegionSum {

    private int[][] mat;
    private int[][] sumMatrix;


    public MatrixRegionSum(int[][] matrix) {
        this.mat = matrix;
        preComputeSum();
    }

    public int[][] getSumMatrix() {
        return sumMatrix;
    }

    public int getSumByNaiveApproach(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }

    public void preComputeSum() {

        if (mat.length == 0 || mat[0].length == 0) return;

        sumMatrix = new int[mat.length][mat[0].length];

        //initialize sum matrix
        sumMatrix[0][0] = mat[0][0];

        //scan first row
        for (int i = 1; i < mat.length; i++) {
            sumMatrix[i][0] = sumMatrix[i - 1][0] + mat[i][0];
        }

        //scan first column
        for (int j = 1; j < mat[0].length; j++) {
            sumMatrix[0][j] = sumMatrix[0][j - 1] + mat[0][j];
        }

        //scan all the elements from 2nd row and 2nd column onwards
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] + mat[i][j] - sumMatrix[i - 1][j - 1]; // memoize the sum
            }
        }

    }

    public int getSumByOptimizedApproach(int row1, int col1, int row2, int col2) {
        int OA, OB, OC, OD;
        if (row1 == 0 || col1 == 0)
            OA = 0;
        else
            OA = this.sumMatrix[row1 - 1][col1 - 1];

        if (row1 == 0)
            OB = 0;
        else
            OB = this.sumMatrix[row1 - 1][col2];

        if (col1 == 0)
            OC = 0;
        else
            OC = this.sumMatrix[row2][col1 - 1];

        OD = this.sumMatrix[row2][col2];

        return OD - OC - OB + OA;

    }
}
