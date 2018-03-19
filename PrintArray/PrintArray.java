import java.util.Arrays;

public class PrintArray {
    public static void main(String[] args) {
        int array[] = { 12, 11, 13, 5, 6, 7 };
        int n = array.length;

        printArrayAdvanced(array);

        for (int i = 0; i < n; i++) {
            printArrayBasic(array, i);
        }
    }

    static void printArrayAdvanced(int[] array) {
        System.out.print(Arrays.toString(array));
    }

    static void printArrayBasic(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
