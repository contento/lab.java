public class HeapSort {
    public static void main(String[] args) {
        int[] array = { 12, 11, 13, 5, 6, 7 };
        int n = array.length;

        printArray(array, n);
        printArray(array, n);
    }

    private static void printArray(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] );
        }
        System.out.println();
    }
}