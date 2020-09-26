package guidewire;

import java.util.*;

public class Question1 {

    public static int solution(String S) {
        // write your code in Java SE 8

        //create a map of phone number and bill
        HashMap<String, Integer> numberBillMap = new HashMap<>();

        //create a map of number and call duration
        HashMap<String, Integer> numberTime = new HashMap<>();

        String[] inputLines = splitInput(S);
        for (int i = 0; i < inputLines.length; i++) {
            String[] billingInput = splitLine(inputLines[i]);

            String time = billingInput[0];
            String phoneNumber = billingInput[1];

            int billPerCall = calculateBillPerCall(time);

            numberBillMap.put(phoneNumber, numberBillMap.getOrDefault(phoneNumber, 0) + billPerCall);
            numberTime.put(phoneNumber, numberTime.getOrDefault(phoneNumber, 0) + calculateSeconds(time));

        }

        // if only has one element in map, simply return its bill
        if(numberBillMap.keySet().size() <= 1) {
            Map.Entry<String, Integer> entry = numberBillMap.entrySet().iterator().next();
            return numberBillMap.get(entry.getKey());
        }


        // keep track of max call duration
        Optional<Integer> maxFromDict = numberTime.values().stream().reduce(Integer::max);


        List<String> phoneNumberList = new ArrayList<>();

        //create a list of all phone numbers who have same call duration
        numberTime.forEach((key, value) -> {
            if (value.equals(maxFromDict.get()))
                phoneNumberList.add(key);
        });

        //get smallest phone number in case of tie
        String minPhoneNumber = phoneNumberList.get(0);
        for (String phoneNumber : phoneNumberList) {
            if (isPhone1SmallerThanPhone2(phoneNumber, minPhoneNumber))
                minPhoneNumber = phoneNumber;
        }

        //waive of bill amount from calculation
        numberBillMap.remove(minPhoneNumber);

        Integer totalBill = numberBillMap.values().stream().reduce(0, Integer::sum);

        return totalBill;
    }

    private static String[] splitLine(String s) {
        String[] split = s.split(",");
        return split;
    }

    private static String[] splitInput(String S) {
        return S.split("\n");
    }


    public static boolean isMinutesLessThanFive(String s) {
        return getMinutes(s) < 5;
    }

    public static int getMinutes(String s) {
        return Integer.parseInt(s.substring(3, 5));
    }

    public static int getHours(String s) {
        return Integer.parseInt(s.substring(0, 2));
    }

    public static int getSeconds(String s) {
        return Integer.parseInt(s.substring(6, 8));
    }

    public static int calculateSeconds(String s) {
        return getSeconds(s) + 60*getMinutes(s) + 3600*getHours(s);
    }

    public static int calculateBillPerCall(String s) {
        int seconds = calculateSeconds(s);
        if(seconds < 300)
            return seconds*3;
        else {
            if(getSeconds(s) > 0)
                return (getMinutes(s) + 1) * 150;
            else
                return getMinutes(s)*150;
        }
    }

    public static boolean isPhone1GreaterThanPhone2(String s1, String s2) {
        String sanitizeS1 = s1.replace("-", "");
        String sanitizeS2 = s2.replace("-", "");
        Long parsedValueS1 = Long.valueOf(sanitizeS1);
        Long parsedValueS2 = Long.valueOf(sanitizeS2);
        return parsedValueS1 > parsedValueS2;
    }

    public static boolean isPhone1SmallerThanPhone2(String s1, String s2) {
        return !isPhone1GreaterThanPhone2(s1, s2);
    }
}
