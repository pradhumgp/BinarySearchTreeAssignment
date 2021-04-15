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
                if(searchElement.compareTo(temp.getData()) <0){
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
        if (root != null) {
            Node<E> current = root;
            Node<E> parent = null;
            while (current != null) {
                if (data.compareTo(current.getData()) == 0) {
                    break;
                }
                parent = current;
                if (data.compareTo(current.getData()) < 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            if (current != null) {
                if (isLeafNode(current)) {
                    if (parent == null) {
                        root = null;
                    } else {
                        if (data.compareTo(parent.getData()) < 0) {
                            parent.setLeft(null);
                        } else {
                            parent.setRight(null);
                        }
                    }
                }
            } else if (isLeftChild(current)) {
                if (parent == null) {
                    root = root.getLeft();
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(current.getLeft());
                    } else {
                        parent.setRight(current.getLeft());
                    }
                }
            } else if (isRightChild(current)) {
                if (parent == null) {
                    root = root.getRight();
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(current.getRight());
                    } else {
                        parent.setRight(current.getRight());
                    }
                }
            } else {
                Node<E> successor = getSuccessor(current);
                delete(successor.getData());
                successor.setLeft(current.getLeft());
                successor.setRight(current.getRight());
                if (parent == null) {
                    root = successor;
                } else {
                    if (data.compareTo(parent.getData()) < 0) {
                        parent.setLeft(successor);
                    } else {
                        parent.setRight(successor);
                    }
                }
            }


        } else {
            System.out.println("Element not fount");
        }
    }


    private boolean isRightChild(Node<E> current) {
        return current.getLeft() == null && current.getRight() != null;
    }

    private boolean isLeftChild(Node<E> current) {
        return current.getLeft() != null && current.getRight() == null;
    }

    private boolean isLeafNode(Node<E> current) {
        return current.getData() == null && current.getRight() == null;
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> result = null;
        Node<E> temp = node.getRight();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        result = temp;
        return result;
    }

    @Override
    public int height(Node<E> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Integer.max(height(node.getLeft()), height(node.getRight()));
    }


}
