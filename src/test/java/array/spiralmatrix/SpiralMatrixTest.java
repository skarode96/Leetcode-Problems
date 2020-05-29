package array.spiralmatrix;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SpiralMatrixTest {

    @Test
    public void shouldPrintMatrixInSpiralOrder() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = SpiralMatrix.spiralOrder(matrix);
        Assert.assertEquals(1, integers.get(0).intValue());
        Assert.assertEquals(2, integers.get(1).intValue());
        Assert.assertEquals(3, integers.get(2).intValue());
        Assert.assertEquals(6, integers.get(3).intValue());
        Assert.assertEquals(9, integers.get(4).intValue());
        Assert.assertEquals(8, integers.get(5).intValue());
        Assert.assertEquals(7, integers.get(6).intValue());
        Assert.assertEquals(4, integers.get(7).intValue());
        Assert.assertEquals(5, integers.get(8).intValue());
    }

}