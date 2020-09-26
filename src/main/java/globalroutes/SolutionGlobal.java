package globalroutes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionGlobal {

    public static int solve(String S) {

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int numberOfOddChars = 0;

        for(Character ch: S.toCharArray()){
            if(charCountMap.containsKey(ch)){
                int count = charCountMap.get(ch);
                count += 1;
                charCountMap.put(ch, count);
                if(count % 2 == 1){
                    numberOfOddChars++;
                } else{
                    numberOfOddChars--;
                }
            }else {
                charCountMap.put(ch, 1);
                numberOfOddChars++;
            }
        }

        return numberOfOddChars;
    }

    public static String solve2(String S, int K) {
        List<String> week = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        int currentDayIndex = week.indexOf(S);
        int finalDayIndex = currentDayIndex + K;
        int resultIndex = finalDayIndex % week.size();
        return week.get(resultIndex);
    }
}
