package sortingalgo;

import java.util.Arrays;

public class RadixSort {
    public static int[] sort(int[] arr) {
        if(isArrayEmpty(arr))
            return arr;

        int maximumNumber = Arrays.stream(arr).max().getAsInt();
        int numberOfDigits = calculateNumberOfDigitsIn(maximumNumber);
        int placeValue = 1;
        while (numberOfDigits-- > 0) {
            countingSort(arr, placeValue);
            placeValue *= 10;
        }
        return arr;
    }

    private static void countingSort(int[] arr, int placeValue) {

        int decimalRange = 10;
        int[] frequency = new int[decimalRange];
        int[] sortedValues = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int digit = (arr[i]/placeValue) % decimalRange;
            frequency[digit]++;
        }

        for (int i = 1; i < decimalRange; i++) {
            frequency[i] = frequency[i] + frequency[i-1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / placeValue) % decimalRange;
            sortedValues[frequency[digit] - 1] = arr[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, arr, 0, arr.length);
    }

    private static int calculateNumberOfDigitsIn(int maximumNumber) {
        return (int) Math.log(maximumNumber);
    }

    private static boolean isArrayEmpty(int[] arr) {
        return arr.length == 0;
    }

}
