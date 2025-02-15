package main;

import implementation.MyBinarySearchTree;

public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bstree = new MyBinarySearchTree<>();
        bstree.insert(100);
        bstree.insert(90);
        bstree.insert(110);
        bstree.insert(85);
        bstree.insert(95);
        bstree.insert(105);
        bstree.insert(115);
        bstree.inOrder(bstree.root);
        System.out.println();
        bstree.preOrder(bstree.root);
        System.out.println();
        bstree.postOrder(bstree.root);
        System.out.println();
        System.out.println(bstree.height(bstree.root));
        System.out.println(bstree.search(115));
        System.out.println(bstree.search(200));
    }
}
