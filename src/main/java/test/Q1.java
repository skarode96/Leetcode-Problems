package test;

public class Q1 {

    public static int solve(int N) {

        // write your code in Java SE 8
        String binaryString = Integer.toBinaryString(N);
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                end = i;
                maxLength = Integer.max(end - start - 1, maxLength);
                System.out.println(maxLength + i);
                start = i;
            }
        }
        return maxLength;
    }
}
