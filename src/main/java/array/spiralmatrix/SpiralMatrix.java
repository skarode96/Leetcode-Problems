package array.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> result = new ArrayList<>();

        //check for empty matrix conditions // boundary checks
        if (matrix == null || matrix.length == 0)
            return result;

        // row
        int M = matrix.length;
        // column
        int N = matrix[0].length;


        //keep track of 4 boundaries
        int rowStart = 0;
        int rowEnd = M - 1;
        int columnStart = 0;
        int columnEnd = N - 1;

        //while boundaries dont overlap keep on doing following steps

        while (rowStart <= rowEnd && columnStart <= columnEnd) {

            // traverse ->
            for (int i = columnStart; i <= columnEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            //traverse down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][columnEnd]);
            }
            columnEnd--;

            //traverse left <-
            if (rowStart > rowEnd) //boundary conditions
                break;

            for (int i = columnEnd; i >= columnStart; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            //traverse up |^
            if (columnStart > columnEnd) //boundary conditions
                break;
            for (int i = rowEnd; i >= rowStart; i--) {
                result.add(matrix[i][columnStart]);
            }
            columnStart++;
        }

        return result;
    }
}
