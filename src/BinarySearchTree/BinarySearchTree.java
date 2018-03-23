package BinarySearchTree;

import java.util.Arrays;

public class BinarySearchTree {
    public static void main(String[] args) {
        executeCase(new Integer[] { 12, 11, 13, 5, 6, 7 }, new Integer[] { 6, 7 });
        executeCase(new String[] { "Foo", "Bar", "Foo", "Good" }, new String[] { "Bar" });
    }

    private static <T extends Comparable<T>> void executeCase(final T[] initialValues, final T[] deletionValues) {
        Node<T> root = null;

        printArray("Add: ", initialValues);
        root = addToTree(root, initialValues);
        printTreeInOrder(root);

        printArray("Remove: ", deletionValues);
        root = removeFromTree(root, deletionValues);
        printTreeInOrder(root);

        T data = initialValues[0];
        Node<T> node = search(root, data);
        if (node != null) {
            System.out.printf("Found [%s]%n", node.Data);
        } else {
            System.out.printf("Not found [%s]%n", data);
        }
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

    private static <T extends Comparable<T>> Node<T> search(Node<T> root, T data) {
        if (root == null || root.eq(data)) {
            return root;
        }
        if (root.gt(data)) {
            return search(root.Left, data);
        }

        return search(root.Right, data);
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
