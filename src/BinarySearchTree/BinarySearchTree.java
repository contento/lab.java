package BinarySearchTree;

import java.util.Arrays;

import javax.crypto.NullCipher;

public class BinarySearchTree {
    public static void main(String[] args) {
        executeCase(new Integer[] { 12, 11, 13, 5, 6, 7 }, new Integer[] { 1956, 1963 }, new Integer[] { 6, 7 });
    }

    private static <T extends Comparable<T>> void executeCase(final T[] initialValues, final T[] insertionValues,
            final T[] deletionValues) {
        printArray("Original: ", initialValues);

        Node<T> root = null;

        System.out.println("(.) Add");
        root = addToTree(root, initialValues);
        printTreeInOrder(root);

        System.out.println("(+) Add more");
        root = addToTree(root, insertionValues);
        printTreeInOrder(root);

        System.out.println("(-) Remove some");
        root = removeFromTree(root, deletionValues);
        printTreeInOrder(root);
    }

    private static <T extends Comparable<T>> Node<T> addToTree(Node<T> root, T[] values) {
        for (T value : values) {
            root = Insert(root, value);
        }

        return root;
    }


    private static <T extends Comparable<T>> Node<T> removeFromTree(Node<T> root, T[] values) {
        return root;
    }

    private static <T extends Comparable<T>> Node<T> Insert(Node<T> root, T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            if (root.ge(data)) {
                root.Left = Insert(root.Left, data);
            } else {
                root.Right = Insert(root.Right, data);
            }
        }
        return root;
    }

    private static <T extends Comparable<T>> void printTreeInOrder(Node<T> root) {
        if (root != null) {
            printTreeInOrder(root.Left);
            System.out.println(root.Data);
            printTreeInOrder(root.Right);
        }
    }

    private static <T extends Comparable<T>> void printArray(String message, T[] values) {
        System.out.printf("%s%s%n", message, Arrays.toString(values));
    }
}
