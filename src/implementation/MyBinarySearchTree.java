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
    public void inOrder(myinterface.Node<E> node) {

    }

    @Override
    public void preOrder(myinterface.Node<E> node) {

    }

    @Override
    public void postOrder(myinterface.Node<E> node) {

    }

    @Override
    public void reverseInOrder(myinterface.Node<E> node) {

    }

    @Override
    public void delete(E data) {

    }

    @Override
    public int height(myinterface.Node<E> node) {
        return 0;
    }
}
