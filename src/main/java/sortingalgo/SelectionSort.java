package sortingalgo;

public class SelectionSort {

    public static int[] sort(int[] arr) {

        if(isArrayEmpty(arr))
            return arr;

        for (int i = 0; i < arr.length; i++) {

            int indexOfMin = i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] < arr[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            swap(arr, i, indexOfMin);
        }
        return arr;
    }

    private static boolean isArrayEmpty(int[] arr) {
        return arr.length == 0;
    }

    private static void swap(int[] arr, int index1, int index2) {
        if (index1 == index2)
            return;
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
}
