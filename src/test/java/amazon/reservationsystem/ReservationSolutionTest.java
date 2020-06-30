package amazon.reservationsystem;

import org.junit.Assert;
import org.junit.Test;

public class ReservationSolutionTest {

    @Test
    public void testSolution1() {
        int actual = ReservationSystem.solve("1A 2F 1C", 2);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testSolution2() {
        int actual = ReservationSystem.solve("", 1);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testSolution3() {
        int actual = ReservationSystem.solve("1A 2F 1C 2B", 2);
        Assert.assertEquals(1, actual);
    }


}