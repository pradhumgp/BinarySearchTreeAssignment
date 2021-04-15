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
        if(root != null){
            Node<E> temp = root;
            while(temp != null){
                if(temp.getData().compareTo(searchElement) ==0){
                    return true;
                }
                if(temp.getData().compareTo(searchElement) <0){
                    temp = temp.getLeft();
                }
                else{
                    temp = temp.getRight();
                }
            }
        }
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
            if (node != null) {
                postOrder(node.getLeft());
                postOrder(node.getRight());
                System.out.print(node.getData() + " ");
            }
    }

    @Override
    public void reverseInOrder(Node<E> node) {
        if (node != null) {
            reverseInOrder(node.getRight());
            System.out.print(node.getData() + " ");
            reverseInOrder(node.getLeft());
        }

    }

    @Override
    public void delete(E data) {

    }

    @Override
    public int height(Node<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Integer.max(height(node.getLeft()), height(node.getRight()));
    }


}
