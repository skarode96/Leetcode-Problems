package sortingalgo;

public class QuickSort {


    private static boolean isArrayEmpty(int[] arr) {
        return arr.length == 0;
    }

    public static int[] sortArray(int[] arr) {
        if (isArrayEmpty(arr))
            return arr;

        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            int partitionIndex = partition(arr, leftIndex, rightIndex);
            sort(arr, leftIndex, partitionIndex - 1);
            sort(arr, partitionIndex + 1, rightIndex);
        }

    }

    private static int partition(int[] arr, int leftIndex, int rightIndex) {

        int pivot = arr[leftIndex];
        int i = leftIndex + 1;
        int j = rightIndex;

        while (i < j) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, j, leftIndex);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
