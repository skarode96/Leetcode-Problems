package guidewire;

import org.junit.Test;

public class Question3TestGuideWire {

    @Test
    public void tesStringQuestion1(){
        String input = "asdqwe";
        String solve = Question3G.solve(input);
        System.out.println(solve);
    }

    @Test
    public void tesStringQuestion2(){
        String input = "asdqwe123";
        String solve = Question3G.solve(input);
        System.out.println(solve);
    }

    @Test
    public void tesStringQuestion3(){
        String input = "asd12qwe123";
        String solve = Question3G.solve(input);
        System.out.println(solve);
    }


}