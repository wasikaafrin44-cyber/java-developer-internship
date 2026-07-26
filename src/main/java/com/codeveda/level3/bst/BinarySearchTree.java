package com.codeveda.level3.bst;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int data) {

        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, int data) {

        if (node == null) {
            return new TreeNode(data);
        }

        if (data < node.data) {

            node.left = insert(node.left, data);

        } else if (data > node.data) {

            node.right = insert(node.right, data);
        }

        return node;
    }

    public boolean search(int data) {

        return search(root, data);
    }

    private boolean search(TreeNode node, int data) {

        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        if (data < node.data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }
    public void delete(int data) {
        root = delete(root, data);
    }

    private TreeNode delete(TreeNode node, int data) {

        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {

            if (node.left == null && node.right == null) {

                return null;
            }

            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            TreeNode successor = findMin(node.right);

            node.data = successor.data;

            node.right = delete(node.right, successor.data);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode node) {

        if (node != null) {

            inOrder(node.left);

            System.out.print(node.data + " ");

            inOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);

        System.out.println();
    }

    private void preOrder(TreeNode node) {

        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(TreeNode node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}