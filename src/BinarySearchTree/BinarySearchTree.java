package BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
    public static void main(String[] args) {
        executeCase(new Integer[] { 12, 11, 13, 5, 6, 7 }, new Integer[] { 6, 7 }, new Integer(Integer.MIN_VALUE),
                new Integer(Integer.MAX_VALUE));
        executeCase(new String[] { "Foo", "Bar", "Foo", "Good" }, new String[] { "Bar" }, "", "");
    }

    private static <T extends Comparable<T>> void executeCase(final T[] initialValues, final T[] deletionValues,
            T minValue, T maxValue) {
        Node<T> root = null;

        // Add
        printArray("(+) Add: ", initialValues);
        root = addToTree(root, initialValues);
        printList(" (T) Tree: ", toInOrderList(new ArrayList<>(), root));

        // Remove
        printArray("(-) Delete: ", deletionValues);
        root = deleteFromTree(root, deletionValues);
        printList(" (T) Tree: ", toInOrderList(new ArrayList<>(), root));

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

        if (initialValues[0].getClass() == Integer.class) {
            // TODO: not ready yet for other types
            System.out.printf("(*) BST: %s%n", isBinarySearchTree(root, minValue, maxValue));
        }
    }

    private static <T extends Comparable<T>> boolean isBinarySearchTree(Node<T> root, T minValue, T maxValue) {
        if (root == null)
            return true;

        return (root.ge(minValue) && root.lt(maxValue) && isBinarySearchTree(root.Left, minValue, root.Data)
                && isBinarySearchTree(root.Right, root.Data, maxValue));
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

    private static <T extends Comparable<T>> List<T> toInOrderList(List<T> list, Node<T> root) {
        if (root != null) {
            toInOrderList(list, root.Left);
            list.add(root.Data);
            toInOrderList(list, root.Right);
        }
        return list;
    }

    private static <T extends Comparable<T>> void printArray(String message, T[] values) {
        System.out.printf("%s%s%n", message, Arrays.toString(values));
    }

    private static <T extends Comparable<T>> void printList(String message, List<T> values) {
        System.out.printf("%s%s%n", message, values.toString());
    }
}
