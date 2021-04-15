package implementation;

import myinterface.BinarySearchTreeADT;

public class MyBinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {
    //complete this class
    public Node<E> root;

    public MyBinarySearchTree() {
        this.root = null;
    }


    @Override
    public void insert(E data) {
        if(root == null){
            root = new Node<>(data);
        }
        else{
            Node<E> parent;
            Node<E> current =root;
            while(current != null){
                parent = current;
                if(data.compareTo(current.getData()) <0 ){
                    current = current.getLeft();
                    if(current == null){
                        parent.setLeft(new Node<>(data));
                    }
                }
                else{
                    current = current.getRight();
                    if(current == null){
                        parent.setRight(new Node<>(data));
                    }
                }
            }
        }
    }

    @Override
    public boolean search(E searchElement) {
        return false;
    }

    @Override
    public void inOrder(Node<E> node) {
        if(node!=null){
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }

    }

    @Override
    public void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }

    }

    @Override
    public void postOrder(Node<E> node) {

    }

    @Override
    public void reverseInOrder(Node<E> node) {

    }

    @Override
    public void delete(E data) {

    }

    @Override
    public int height(Node<E> node) {
        return 0;
    }


}
