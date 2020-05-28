package sortingalgo;

import java.util.Arrays;

public class CountingSort {
    public static int[] sort(int[] arr) {

        if(isArrayEmpty(arr))
            return arr;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int[] countArray = new int[max-min+1];

        int arrLength = arr.length;
        int[] resultArr = new int[arrLength];

        //maintain count of each element
        Arrays.stream(arr).forEach(element -> {
            countArray[element-min] += 1;
        });

        //maintain cumulative count of each element
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] = countArray[i-1] + countArray[i];
        }

        //construct result array
        for (int i = 0; i < arrLength; i++) {
            int element = arr[i];
            resultArr[countArray[element-min] - 1] = element;
            countArray[element-min]--;
        }

        return resultArr;
    }

    private static boolean isArrayEmpty(int[] arr) {
        return arr.length == 0;
    }
}
