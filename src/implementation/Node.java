package implementation;

public class Node<E extends Comparable<E>> implements myinterface.Node<E> {
    private int data;
    private Node<E> left;
    private Node<E> right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
