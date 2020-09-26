package globalroutes;

import org.junit.Assert;
import org.junit.Test;

public class SolutionGlobalTest {

    @Test
    public void test1(){
        int result = SolutionGlobal.solve("aabbccd");
        Assert.assertEquals(1, result);
    }

    @Test
    public void test2(){
        int result = SolutionGlobal.solve("axxaxa");
        Assert.assertEquals(2, result);
    }

    @Test
    public void test3(){
        int result = SolutionGlobal.solve("aaaa");
        Assert.assertEquals(0, result);
    }

    @Test
    public void test4(){
        String result = SolutionGlobal.solve2("Wed", 2);
        Assert.assertEquals("Fri", result);
    }

    @Test
    public void test5(){
        String result = SolutionGlobal.solve2("Wed", 10);
        Assert.assertEquals("Sat", result);
    }

    @Test
    public void test6(){
        String result = SolutionGlobal.solve2("Wed", 0);
        Assert.assertEquals("Wed", result);
    }
    @Test
    public void test7(){
        String result = SolutionGlobal.solve2("Wed", 14);
        Assert.assertEquals("Wed", result);
    }

}