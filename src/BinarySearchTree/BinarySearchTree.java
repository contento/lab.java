package BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
    public static void main(String[] args) {
        executeCase(new Integer[] { 12, 11, 13, 5, 6, 7 }, new Integer[] { 6, 7 });
        executeCase(new String[] { "Foo", "Bar", "Foo", "Good" }, new String[] { "Bar" });
    }

    private static <T extends Comparable<T>> void executeCase(final T[] initialValues, final T[] deletionValues) {
        Node<T> root = null;

        // Add
        printArray("(+) Add: ", initialValues);
        root = addToTree(root, initialValues);
        printTreeInOrder(root);

        // Remove
        printArray("(-) Delete: ", deletionValues);
        root = deleteFromTree(root, deletionValues);
        printTreeInOrder(root);

        // Find Min
        Node<T> node = findMin(root);
        if (node != null) {
            System.out.printf("(.) Min Value [%s]%n", node.Data);
        } else {
            System.out.println("(.) Min Value not found");
        }

        // Search
        List<T> searchList = new ArrayList<>();
        searchList.add(initialValues[0]);
        searchList.add(deletionValues[0]);
        for (T value : searchList) {
            node = search(root, value);
            if (node != null) {
                System.out.printf("(.) Found [%s]%n", node.Data);
            } else {
                System.out.printf("(.) Not found [%s]%n", value);
            }
        }
    }

    private static <T extends Comparable<T>> Node<T> addToTree(Node<T> root, T[] values) {
        for (T value : values) {
            root = insert(root, value);
        }
        return root;
    }

    private static <T extends Comparable<T>> Node<T> deleteFromTree(Node<T> root, T[] values) {
        for (T value : values) {
            delete(root, value);
        }
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

    private static <T extends Comparable<T>> Node<T> findMin(Node<T> root) {
        if (root == null) {
            return root;
        }

        while (root.Left != null) {
            root = root.Left;
        }

        return root;
    }

    private static <T extends Comparable<T>> Node<T> insert(Node<T> root, T data) {
        if (root == null) {
            root = new Node<T>(data);
        } else {
            if (root.ge(data)) {
                root.Left = insert(root.Left, data);
            } else {
                root.Right = insert(root.Right, data);
            }
        }
        return root;
    }

    private static <T extends Comparable<T>> Node<T> delete(Node<T> root, T data) {
        if (root == null) {
            return root;
        }

        if (root.gt(data)) {
            root.Left = delete(root.Left, data);
        } else if (root.lt(data)) {
            root.Right = delete(root.Right, data);
        } else {
            if (root.Left == null) {
                // one node: the right one
                root = root.Right;
            } else if (root.Right == null) {
                // one node: the left one
                root = root.Left;
            } else {
                // two nodes: find the min and delete the corresponding
                Node<T> minNode = findMin(root.Right);
                root.Data = minNode.Data;
                root.Right = delete(root.Right, minNode.Data);
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
