package sortingalgo;

public class HeapSort {

    public static int[] sort(int[] arr) {

        if (isArrayEmpty(arr))
            return arr;

        int length = arr.length;

        //build max heap
        for (int i = (length) / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }

        //for each element from last index swap it with first and perform heapify
        for (int i = length - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
        return arr;
    }

    private static void heapify(int[] arr, int length, int index) {

        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left >= length || right >= length)
            return;

        if (arr[left] > arr[index] || arr[right] > arr[index]) {

            if (arr[left] > arr[right]) {
                swap(arr, left, index);
                heapify(arr, length, left);
            } else {
                swap(arr, right, index);
                heapify(arr, length, right);
            }
        }
    }

    private static boolean isArrayEmpty(int[] arr) {
        return arr.length == 0;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }
}
