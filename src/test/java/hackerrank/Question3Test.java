package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question3Test {

    @Test
    public void test() {
        List<List<Character>> planetsMap = new ArrayList<>();
        List<Character> row1 = Arrays.asList('A','E','E');
        List<Character> row2 = Arrays.asList('A','E','E');
        List<Character> row3 = Arrays.asList('A','A','D');

        planetsMap.add(row1);
        planetsMap.add(row2);
        planetsMap.add(row3);

        int i = Question3H.transmissionLength(planetsMap);

        Assert.assertEquals(i, 5);
    }

    @Test
    public void test2() {
        List<List<Character>> planetsMap = new ArrayList<>();
        List<Character> row1 = Arrays.asList('A','A','E');
        List<Character> row2 = Arrays.asList('A','A','A');
        List<Character> row3 = Arrays.asList('E','E','D');

        planetsMap.add(row1);
        planetsMap.add(row2);
        planetsMap.add(row3);

        int i = Question3H.transmissionLength(planetsMap);

        Assert.assertEquals(i, 6);
    }

    @Test
    public void test3() {
        List<List<Character>> planetsMap = new ArrayList<>();
        List<Character> row1 = Arrays.asList('A','A','D');
        List<Character> row2 = Arrays.asList('E','E','E');
        List<Character> row3 = Arrays.asList('E','E','E');

        planetsMap.add(row1);
        planetsMap.add(row2);
        planetsMap.add(row3);

        int i = Question3H.transmissionLength(planetsMap);

        Assert.assertEquals(i, 3);
    }

    @Test
    public void test4() {
        List<List<Character>> planetsMap = new ArrayList<>();
        List<Character> row1 = Arrays.asList('A','A','E');
        List<Character> row2 = Arrays.asList('E','E','D');
        List<Character> row3 = Arrays.asList('E','E','E');

        planetsMap.add(row1);
        planetsMap.add(row2);
        planetsMap.add(row3);

        int i = Question3H.transmissionLength(planetsMap);

        Assert.assertEquals(i, -1);
    }

    @Test
    public void test5() {
        List<List<Character>> planetsMap = new ArrayList<>();
        List<Character> row1 = Arrays.asList('A','A','A','E');
        List<Character> row2 = Arrays.asList('E','A','A','A');
        List<Character> row3 = Arrays.asList('E','E','E','D');
        List<Character> row4 = Arrays.asList('E','E','E','E');

        planetsMap.add(row1);
        planetsMap.add(row2);
        planetsMap.add(row3);
        planetsMap.add(row4);

        int i = Question3H.transmissionLength(planetsMap);

        Assert.assertEquals(6, i);
    }

}