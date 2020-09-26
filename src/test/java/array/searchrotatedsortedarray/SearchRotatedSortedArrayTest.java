package array.searchrotatedsortedarray;

import org.junit.Assert;
import org.junit.Test;

public class SearchRotatedSortedArrayTest {

    @Test
    public void test_shouldfindelement_insortedarray1(){
        int actualIndex = SearchRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6);
        int expectedIndex = 2;
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void test_shouldfindelement_insortedarray2(){
        int actualIndex = SearchRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4);
        int expectedIndex = 0;
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void test_shouldfindelement_insortedarray3(){
        int actualIndex = SearchRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        int expectedIndex = 4;
        Assert.assertEquals(expectedIndex, actualIndex);
    }
}