/******************************************************************************
 *  Compilation:  javac Heap.java
 *  Execution:    java Heap < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/24pq/tiny.txt
 *                https://algs4.cs.princeton.edu/24pq/words3.txt
 *
 *  Sorts a sequence of strings from standard input using heapsort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Heap < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Heap < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 ******************************************************************************/

/**
 *  The {@code Heap} class provides a static methods for heapsorting
 *  an array.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

package Heap;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {

    // This class should not be instantiated.
    private Heap() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param pq the array to be sorted
     */
    public static <T> void sort(Comparable<T>[] pq) {
        int n = pq.length;
        for (int k = n / 2; k >= 1; k--)
            sink(pq, k, n);
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

    /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private static <T> void sink(Comparable<T>[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;

            if (j < n && less(pq, j, j + 1))
                j++;
            if (!less(pq, k, j))
                break;
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
    * Helper functions for comparisons and swaps.
    * Indices are "off-by-one" to support 1-based indexing.
    ***************************************************************************/
    private static <T> boolean less(Comparable<T>[] pq, int i, int j) {
        T o = (T) pq[j - 1]; // TODO: fix this warning !
        return pq[i - 1].compareTo(o) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    // print array to standard output
    private static <T> void show(Comparable<T>[] a) {
        System.out.println(Arrays.toString(a));
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            String nextLine = input.nextLine();
            String[] a = nextLine.split("\\s+|\\s*[\\,|\\;]\\s*");
            show(a);

            Heap.sort(a);
            show(a);
        } finally {
            input.close();

        }
    }
}
