package sortingalgo;

public class BubbleSort {

    public static int[] sort(int[] arr) {

        if(isArrayEmpty(arr))
            return arr;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 1; j < arr.length; j++) {
                if(arr[j] < arr[j-1])
                    swap(arr, j, j-1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    private static boolean isArrayEmpty(int[] arr) {
            return arr.length == 0;
    }

    public static int[] optimizedSort(int[] arr) {

        if(isArrayEmpty(arr))
            return arr;

        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped = false;
            for (int j = 1; j < arr.length; j++) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j - 1);
                    isSwapped = true;
                }
            }
            if(!isSwapped)
                break;
        }
        return arr;
    }
}
