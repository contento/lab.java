package HeapSort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        executeCase(new Integer[] { 12, 11, 13, 5, 6, 7 });
        executeCase(new String[] { "Foo", "Bar", "Foo", "Best" });
        executeCase(new Double[] { 3.1415, 1.7172, 0.7071, 1.4142, 1024.0 });
    }

    private static <T extends Comparable<T>> void executeCase(final T[] values) {
        printArray("Original: ", values);
        buildHeap(values);
        sort(values);
    }

    private static <T extends Comparable<T>> void buildHeap(T[] values) {
        final int heapSize = values.length;
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(values, i, heapSize);
        }
        printArray("  Heap: ", values);
    }

    private static <T extends Comparable<T>> void sort(T[] values) {
        final int n = values.length;
        for (int heapSize = n - 1; heapSize >= 0; heapSize--) {
            swap(values, 0, heapSize);
            heapify(values, 0, heapSize);
        }
        printArray("  Sorted: ", values);
    }

    private static <T extends Comparable<T>> void heapify(T[] values, int i, int heapSize) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < heapSize && less(values, largest, left))
            largest = left;

        if (right < heapSize && less(values, largest, right))
            largest = right;

        if (largest != i) {
            swap(values, i, largest);
            heapify(values, heapSize, largest);
        }

        printWithIndexAndLength(values, heapSize, i);
    }

    private static <T extends Comparable<T>> boolean less(T[] values, int i, int j) {
        return values[i].compareTo(values[j]) < 0;
    }

    public static final <T> void swap(T[] values, int i, int j) {
        T t = values[i];
        values[i] = values[j];
        values[j] = t;
    }

    private static <T extends Comparable<T>> void printArray(String message, T[] values) {
        System.out.printf("%s%s%n", message, Arrays.toString(values));
    }

    static <T extends Comparable<T>> void printWithLength(T[] values, int n) {
        if (values == null || values.length == 0 || n <= 0)
            return;

        T[] subArray = Arrays.copyOfRange(values, 0, n);
        System.out.printf("  %s(n=%d)%n", Arrays.toString(subArray), n);
    }

    private static <T extends Comparable<T>> void printWithIndexAndLength(T[] values, int n, int i) {
        if (values == null || values.length == 0 || n <= 0)
            return;

        T[] subArray = Arrays.copyOfRange(values, 0, n);
        System.out.printf("    %s(n=%d,i=%d)%n", Arrays.toString(subArray), n, i);
    }
}
