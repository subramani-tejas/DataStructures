package com.codewithtejas.Trees;

public class Tree {
    private Node root;

    // private implementation
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return ("Node: " + value);
        }
    }

    // insert a value
    public void insert(int value) {
        var newNode = new Node(value);

        // if root is null (empty tree)
        if (root == null) {
            root = newNode;
            return;
        }

        // if there's a tree
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
    }

    // lookup a value
    public boolean find(int value) {
        var current = root;

        while (current != null) {
            if (current.value == value) return true;
            current = (value < current.value) ? current.left : current.right;
        }
        return false;
    }

    // find the height of a node
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null) return -1;

        if (root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // find min value in tree
    public int getMin() {
        return getMin(root);
    }

    private int getMin(Node root) {
        // base condition
        if (isLeaf(root)) return root.value;

        var minLeft = getMin(root.left);
        var minRight = getMin(root.right);

        return Math.min(Math.min(minLeft, minRight), root.value);
    }

    // is leaf node?
    private boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    // check 2 trees for equality
    public boolean equals(Tree other) {
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.left, second.left)
                    && equals(first.right, second.right);

        return false;
    }

    // get node(s) at distance k
    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance) {
        if (root == null) return;

        if (distance == 0) {
            System.out.println(root.value);
            return;
        }

        printNodesAtDistance(root.left, distance - 1);
        printNodesAtDistance(root.right, distance - 1);
    }

    // main
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.printNodesAtDistance(3);
    }
}
