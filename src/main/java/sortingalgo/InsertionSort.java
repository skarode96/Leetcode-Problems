package sortingalgo;

public class InsertionSort {
    public static int[] sort(int[] arr) {

        if(isArrayEmpty(arr))
            return arr;

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int indexPointer = i-1;

            while (indexPointer >= 0 && arr[indexPointer] > key) {
                arr[indexPointer + 1] = arr[indexPointer];
                indexPointer--;
            }
            arr[indexPointer+1] = key;
        }

        return arr;
    }

    private static boolean isArrayEmpty(int[] arr) {
        return arr.length == 0;
    }

}
