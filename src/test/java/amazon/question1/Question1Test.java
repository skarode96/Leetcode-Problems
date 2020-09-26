package amazon.question1;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Question1Test {

    @Test
    public void test1(){
        String helpText= "Purchase Order Item Help Can't? find item item is too much part of purchase need fix for image item delivered too fast purchase order to big is purchase order coming? Too big why";
        List<String> excludeWords = new ArrayList<>();
        excludeWords.add("help");
        excludeWords.add("too");
        excludeWords.add("is");
        excludeWords.add("of");
        List<String> resultList = Question1.retrieveMostFrequentlyUsedWords(helpText, excludeWords);
        Assert.assertEquals(2, resultList.size());
        Assert.assertTrue(resultList.contains("purchase"));
        Assert.assertTrue(resultList.contains("item"));
    }


    @Test
    public void test2(){
        String helpText= "Purchase";
        List<String> excludeWords = new ArrayList<>();
        excludeWords.add("help");
        excludeWords.add("too");
        excludeWords.add("is");
        excludeWords.add("of");
        List<String> resultList = Question1.retrieveMostFrequentlyUsedWords(helpText, excludeWords);
        Assert.assertEquals(1, resultList.size());
        Assert.assertTrue(resultList.contains("purchase"));
    }

    @Test
    public void test3(){
        String helpText= "";
        List<String> excludeWords = new ArrayList<>();
        excludeWords.add("help");
        excludeWords.add("too");
        excludeWords.add("is");
        excludeWords.add("of");
        List<String> resultList = Question1.retrieveMostFrequentlyUsedWords(helpText, excludeWords);
        Assert.assertEquals(0, resultList.size());
    }


    @Test
    public void test4(){
        String helpText= "asdas asdas";
        List<String> excludeWords = new ArrayList<>();
        excludeWords.add("asdas");
        List<String> resultList = Question1.retrieveMostFrequentlyUsedWords(helpText, excludeWords);
        Assert.assertEquals(0, resultList.size());
    }

    @Test
    public void test5(){
        String helpText= "asdas asdas aas 50 50 50";
        List<String> excludeWords = new ArrayList<>();
        excludeWords.add("asdas");
        List<String> resultList = Question1.retrieveMostFrequentlyUsedWords(helpText, excludeWords);
        Assert.assertEquals(1, resultList.size());
    }


    @Test
    public void test6(){
        String helpText= "asda's asda's asdas asdas  aas aas";
        List<String> excludeWords = new ArrayList<>();
        excludeWords.add("asda's");
        List<String> resultList = Question1.retrieveMostFrequentlyUsedWords(helpText, excludeWords);
        Assert.assertEquals(2, resultList.size());
        Assert.assertEquals(2, resultList.size());

    }


}