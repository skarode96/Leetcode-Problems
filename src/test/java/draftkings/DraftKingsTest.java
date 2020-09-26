package draftkings;

import org.junit.Assert;
import org.junit.Test;

public class DraftKingsTest {

    @Test
    public void testSolve11(){
        String hello = DraftKings.firstProblem("Hello");
        Assert.assertEquals("Hello", hello);
    }

    @Test
    public void testSolve21(){
        String hello =
                DraftKings.secondProblem("Hello");
        Assert.assertEquals("Hello", hello);
    }
}