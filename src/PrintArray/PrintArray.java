package PrintArray;

import java.util.Arrays;

public class PrintArray {
    public static void main(String[] args) {
        int values[] = { 12, 11, 13, 5, 6, 7 };
        int n = values.length;

        System.out.println(Arrays.toString(values));

        printInSteps(values, n);
    }

    private static void printInSteps(int[] values, int n) {
        for (int i = 0; i < n; i++) {
            print(values, i + 1);
        }
    }

    static void print(int[] values, int n) {
        if (values == null || values.length == 0 || n <= 0)
            return;

        String subArray = Arrays.toString(Arrays.copyOfRange(values, 0, n));

        System.out.printf("[...](%d) => %s%n", n, subArray);
    }
}
