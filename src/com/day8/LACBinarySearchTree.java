package com.day8;

/**
 * This class provides a method to find the Lowest Common Ancestor (LCA)
 * of two nodes in a Binary Search Tree (BST).
 */
public class LACBinarySearchTree {

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        /**
         * Constructor to create a tree node with a given value.
         *
         * @param x the value of the tree node
         */
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Finds the lowest common ancestor (LCA) of two given nodes in a binary tree.
     *
     * @param root the root of the binary tree
     * @param p    one of the target nodes
     * @param q    the other target node
     * @return the lowest common ancestor of nodes p and q
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if root is null or matches one of the target nodes
        if (root == null || root == p || root == q)
            return root;

        // Recursively search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If one node is found in left and the other in right, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (either left or right)
        return (left != null) ? left : right;
    }

    /**
     * Main method to test the lowestCommonAncestor method.
     *
     * Constructs the following binary search tree:
     *
     *         6
     *       /   \
     *      2     8
     *     / \   / \
     *    0   4 7   9
     *       / \
     *      3   5
     *
     * Then finds the LCA of nodes 2 and 8.
     */
    public static void main(String[] args) {

        // Construct the binary search tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Define the nodes to find LCA for
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8

        // Find and print the lowest common ancestor
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("The LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
