package guidewire;

import org.junit.Assert;
import org.junit.Test;

public class Question1Test {
    @Test
    public void testOutput1(){

        int solve = Question1.solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090");
        Assert.assertEquals(900, solve);

    }

    @Test
    public void testOutput2(){

        int solve = Question1.solution("00:01:07,400-234-090");
        Assert.assertEquals(201, solve);

    }


    @Test
    public void testOutput3(){

        int solve = Question1.solution("00:01:07,400-234-090\n00:05:01,701-080-080");
        Assert.assertEquals(201, solve);

    }

//    @Test
//    public void test2() {
//        int bill = Question1.billForDuration("00:01:07");
//        Assert.assertEquals(201, bill);
//    }

    @Test
    public void test3() {
        boolean lessThanFive;
        lessThanFive = Question1.isMinutesLessThanFive("00:01:07");
         Assert.assertTrue(lessThanFive);
         lessThanFive = Question1.isMinutesLessThanFive("00:06:07");
        Assert.assertFalse(lessThanFive);
    }

    @Test
    public void test4(){
        int seconds = Question1.calculateSeconds("00:01:07");
        Assert.assertEquals(67, seconds);
    }

    @Test
    public void testCalculateMoney() {
        int i;
         i = Question1.calculateBillPerCall("00:01:07");
        Assert.assertEquals(201, i);
         i = Question1.calculateBillPerCall("00:05:00");
        Assert.assertEquals(750, i);
         i = Question1.calculateBillPerCall("00:05:01");
        Assert.assertEquals(900, i);
    }


    @Test
    public void testPhoneNumberComapare1(){
        String s1 = "400-234-090";
        String s2 = "701-080-080";
        boolean phone1GreaterThanPhone2 = Question1.isPhone1GreaterThanPhone2(s1, s2);
        Assert.assertFalse(phone1GreaterThanPhone2);
    }

    @Test
    public void testPhoneNumberComapare2(){
        String s1 = "400-234-090";
        String s2 = "400-080-080";
        boolean phone1GreaterThanPhone2 = Question1.isPhone1GreaterThanPhone2(s1, s2);
        Assert.assertTrue(phone1GreaterThanPhone2);
    }


    @Test
    public void testGetMinutes(){
        int minutes = Question1.getMinutes("00:01:07");
        Assert.assertEquals(1, minutes);
    }

    @Test
    public void testGetHours(){
        int hours = Question1.getHours("00:01:07");
        Assert.assertEquals(0, hours);
    }

    @Test
    public void testGetSeconds(){
        int seconds = Question1.getSeconds("00:01:07");
        Assert.assertEquals(7, seconds);
    }



}