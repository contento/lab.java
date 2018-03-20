package PrintArray;

import java.util.Arrays;

public class PrintArray {
    public static void main(String[] args) {
        int array[] = { 12, 11, 13, 5, 6, 7 };
        int n = array.length;

        printArrayAdvanced(array);

        for (int i = 0; i < n; i++) {
            printArrayBasic(array, i+1);
        }
    }

    static void printArrayAdvanced(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    static void printArrayBasic(int[] array, int n) {
        if (array == null || array.length == 0 || n <= 0)
            return;

        System.out.printf("[](%d) => ", n);
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
