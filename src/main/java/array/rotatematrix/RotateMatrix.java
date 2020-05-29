package array.rotatematrix;

public class RotateMatrix {

    public static void rotate(int[][] matrix) {
        if (matrix.length == 0)
            return;
        mirrorRows(matrix);
        swapLowerTriangular(matrix);
    }

    public static void swapLowerTriangular(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                    swap(matrix, i, j);
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void mirrorRows(int[][] matrix) {
        for (int i = 0; i < matrix.length/2 ; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }
    }
}
