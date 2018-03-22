package BinarySearchTree;

import java.util.Arrays;

public class BinarySearchTree {
    public static void main(String[] args) {
        executeCase(new Integer[] { 12, 11, 13, 5, 6, 7 }, new Integer[] { 1956, 1963 }, new Integer[] { 6, 7 });
    }

    private static <T extends Comparable<T>> void executeCase(final T[] initialValues, final T[] insertionValues,
            final T[] deletionValues) {
        printArray("Original: ", initialValues);

        Node<T> root = buildTree(initialValues);
        addToTree(root, insertionValues);
        removeFromTree(root, deletionValues);
    }

    private static <T extends Comparable<T>> Node<T> buildTree(T[] values) {
        Node<T> root = null;
        for (T value : values) {
            root = Insert(root, value);
            if (root != null)
                System.out.println(root.Data);
        }

        printTree(root);

        return root;
    }

    private static <T extends Comparable<T>> void addToTree(Node<T> root, T[] insertionValues) {

    }

    private static <T extends Comparable<T>> void removeFromTree(Node<T> root, T[] deletionValues) {

    }

    private static <T extends Comparable<T>> Node<T> Insert(Node<T> root, T data) {
        if (root == null) {
            root = new Node<T>(data);
            return root;
        } else {
            if (root.le(data)) {
                return Insert(root.Left, data);
            } else {
                return Insert(root.Right, data);
            }
        }
    }

    private static <T extends Comparable<T>> void printTree(Node<T> root) {
        if (root == null) {
            System.out.println();
            return;
        } else {
            System.out.printf("%s", root.Data);
            printTree(root.Left);
            printTree(root.Right);
        }
    }

    private static <T extends Comparable<T>> void printArray(String message, T[] values) {
        System.out.printf("%s%s%n", message, Arrays.toString(values));
    }

}
