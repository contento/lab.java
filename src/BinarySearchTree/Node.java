// TODO: move to common
package BinarySearchTree;

public class Node<T extends Comparable<T>> {
    T Data;
    Node<T> Left;
    Node<T> Right;

    Node(T data) {
        Data = data;
        Left = Right = null;
    }

    public boolean eq(T data) {
        return Data.compareTo(data) == 0;
    }

    public boolean lt(T data) {
        return Data.compareTo(data) < 0;
    }

    public boolean le(T data) {
        return Data.compareTo(data) <= 0;
    }

    public boolean gt(T data) {
        return Data.compareTo(data) > 0;
    }

    public boolean ge(T data) {
        return Data.compareTo(data) >= 0;
    }
}
