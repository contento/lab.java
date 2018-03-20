package HeapSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        Integer[] values = { 12, 11, 13, 5, 6, 7 };
        int n = values.length;

        printArray(values);

        buildHeap(values, n);

        printArray(values);

        sort(values, n);

        printArray(values);
    }

    private static void buildHeap(Integer[] values, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(values, n, i);
        }
    }

    private static void sort(Integer[] values, int n) {
        for (int i = n - 1; i >= 0; i--) {
            swap(values, i, 0);
            heapify(values, i, 0);
        }
    }

    private static void heapify(Integer[] values, int n, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && values[left] > values[largest])
            largest = left;

        if (right < n && values[right] > values[largest])
            largest = right;

        if (largest != i) {
            swap(values, i, largest);
            heapify(values, n, largest);
        }

        printWithIndexAndLength(values, n, i);
    }

    public static final <T> void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static void printArray(Integer[] values) {
        System.out.printf("%s%n", Arrays.toString(values));
    }

    static void printWithLength(Integer[] values, int n) {
        if (values == null || values.length == 0 || n <= 0)
            return;

        Integer[] subArray = Arrays.copyOfRange(values, 0, n);
        System.out.printf("  %s(n=%d)%n", Arrays.toString(subArray), n);
    }

    private static void printWithIndexAndLength(Integer[] values, int n, int i) {
        if (values == null || values.length == 0 || n <= 0)
            return;

        Integer[] subArray = Arrays.copyOfRange(values, 0, n);
        System.out.printf("  %s(n=%d,i=%d)%n", Arrays.toString(subArray), n, i);
    }
}
