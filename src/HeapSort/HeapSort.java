package HeapSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        final Integer[] values = { 12, 11, 13, 5, 6, 7 };
        printArray("Original: ", values);

        buildHeap(values);
        sort(values);
    }

    private static void buildHeap(Integer[] values) {
        final int heapSize = values.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(values, i, heapSize);
        }
        printArray("Heap: ", values);
    }

    private static void sort(Integer[] values) {
        final int n = values.length;
        for (int heapSize = n - 1; heapSize >= 0; heapSize--) {
            swap(values, 0, heapSize);
            heapify(values, 0, heapSize);
        }
        printArray("Sorted: ", values);
    }

    private static void heapify(Integer[] values, int i, int heapSize) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < heapSize && values[left] > values[largest])
            largest = left;

        if (right < heapSize && values[right] > values[largest])
            largest = right;

        if (largest != i) {
            swap(values, i, largest);
            heapify(values, heapSize, largest);
        }

        printWithIndexAndLength(values, heapSize, i);
    }

    public static final <T> void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static void printArray(String message, Integer[] values) {
        System.out.printf("%s%s%n", message, Arrays.toString(values));
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
