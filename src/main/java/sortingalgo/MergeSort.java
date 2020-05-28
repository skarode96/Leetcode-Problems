package sortingalgo;

public class MergeSort {


    public static int[] sortArray(int[] arr) {
        if (isArrayEmpty(arr))
            return arr;
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {

            int midIndex = (leftIndex + rightIndex) / 2;

            sort(arr, leftIndex, midIndex);
            sort(arr, midIndex+1, rightIndex);

            merge(arr, leftIndex, midIndex, rightIndex);
        }
    }

    private static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {

        int leftArrayLength = midIndex - leftIndex + 1;
        int[] tempLeftArray = new int[leftArrayLength];

        int rightArrayLength = rightIndex - midIndex;
        int[] tempRightArray = new int[rightArrayLength];


        //copy arrays
        for (int i = 0; i < leftArrayLength ; i++) {
            tempLeftArray[i] = arr[leftIndex+i];
        }
        for (int i = 0; i < rightArrayLength ; i++) {
            tempRightArray[i] = arr[midIndex+i+1];
        }

        //merge them
        int i = 0, j =0, k =leftIndex;
        while ( i < leftArrayLength &&  j < rightArrayLength) {

            if(tempLeftArray[i] <= tempRightArray[j]) {
                arr[k] = tempLeftArray[i];
                i++;
            }
            else {
                arr[k] = tempRightArray[j];
                j++;
            }
            k++;
        }

        //merge remaining element from leftTempArray if any
        while (i < leftArrayLength) {
            arr[k] = tempLeftArray[i];
            i++;
            k++;
        }

        //merge remaining element from rightTempArray if any
        while (j < rightArrayLength) {
            arr[k] = tempRightArray[j];
            j++;
            k++;
        }

    }

    private static boolean isArrayEmpty(int[] arr) {
        return arr.length == 0;
    }
}
