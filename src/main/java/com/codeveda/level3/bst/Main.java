package com.codeveda.level3.bst;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Tree Traversals.....");

        System.out.print("In-order   : ");
        bst.inOrder();

        System.out.print("Pre-order  : ");
        bst.preOrder();

        System.out.print("Post-order : ");
        bst.postOrder();
        System.out.println("\n Search........");
        System.out.println("Search 40 : " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));

        System.out.println("\n Delete Leaf Node (20):");
        bst.delete(20);
        System.out.print("In-order: ");
        bst.inOrder();

        System.out.println("\n===== Delete Node with One Child (30):");
        bst.delete(40);
        System.out.print("In-order: ");
        bst.inOrder();


        System.out.println("\nDelete Node with Two Children (70):");
        bst.delete(70);
        System.out.print("In-order: ");
        bst.inOrder();
    }
}