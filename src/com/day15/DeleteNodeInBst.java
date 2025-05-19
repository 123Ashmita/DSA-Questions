package com.day15;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val; 
    TreeNode left; 
    TreeNode right;

    TreeNode() {} // Empty constructor

    TreeNode(int val) {
        this.val = val; // Constructor with value
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; 
        this.left = left;
        this.right = right;
    }
}

/**
 * This class has a method to delete a node from a Binary Search Tree (BST).
 */
public class DeleteNodeInBst {

    /**
     * Deletes a node with the given key from the BST.
     * 
     * @param root The root node of the BST
     * @param key  The value of the node to delete
     * @return     The root of the updated BST
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // If the tree is empty, return null
        if (root == null) {
            return null;
        }

        // If key is smaller, go to left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If key is larger, go to right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // Node with the key is found
        else {
            // Case 1: Node has no left child
            if (root.left == null) return root.right;
            // Case 2: Node has no right child
            if (root.right == null) return root.left;

            // Case 3: Node has two children
            // Find the minimum node in the right subtree
            TreeNode minNode = findMin(root.right);

            // Replace current node's value with the minimum node's value
            root.val = minNode.val;

            // Delete the minimum node from the right subtree
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    /**
     * Finds the node with the smallest value in the given tree.
     * 
     * @param node The root of the tree or subtree
     * @return     The node with the smallest value
     */
    private TreeNode findMin(TreeNode node) {
        // Keep going left until we reach the smallest node
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Prints the in-order traversal of the tree.
     * 
     * @param root The root node of the tree
     */
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);              // Visit left subtree
            System.out.print(root.val + " "); // Print root
            inorder(root.right);             // Visit right subtree
        }
    }

    /**
     * Main method to test deleting a node from the BST.
     */
    public static void main(String[] args) {
        DeleteNodeInBst bst = new DeleteNodeInBst();

        // Create tree:
        //        5
        //      /   \
        //     3     6
        //    / \     \
        //   2   4     7
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode();
        root.right.right = new TreeNode(7);

        System.out.println("Original Tree : ");
        bst.inorder(root); // Print tree before deletion

        // Delete node with value 3
        root = bst.deleteNode(root, 3);

        System.out.println("\nTree after deleting 3 : ");
        bst.inorder(root); // Print tree after deletion
    }
}
