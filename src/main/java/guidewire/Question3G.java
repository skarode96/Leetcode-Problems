package guidewire;

import java.util.Random;

public class Question3G {

    public static String solve(String input) {

        if(input.isEmpty())
            System.out.println("String is empty");

        String s = input.replaceAll("\\d", "");
        int l = s.length();
        String randomString = "";
        if(l < 10) {
           randomString = getRandomString(10 - l);
        }
        return s + randomString;

    }

    private static String getRandomString(int i) {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(s.charAt(random.nextInt(s.length())));
        }
        return sb.toString();
    }
}
