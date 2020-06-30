package amazon.rottenoranges;

import org.junit.Assert;
import org.junit.Test;

public class RottenOrangesTest {

    @Test
    public void testRottenOrages1(){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int result = RottenOranges.solve(grid);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testRottenOranges2(){

        int[][] grid = {{2,1,1,1,0},{1,1,0,0,2,2},{0,1,1,2,2}};
        int result = RottenOranges.solve(grid);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testRottenOranges3(){

        int[][] grid = {{0}};
        int result = RottenOranges.solve(grid);
        Assert.assertEquals(0, result);
    }

}