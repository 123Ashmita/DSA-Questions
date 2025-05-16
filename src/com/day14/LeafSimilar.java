package com.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LeafSimilar {

    /**
     * Checks if the leaf nodes of two binary trees are similar.
     * 
     * @param root1 The root node of the first tree.
     * @param root2 The root node of the second tree.
     * @return true if the leaf nodes are similar, false otherwise.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Collect the leaf values from both trees
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Traverse both trees to get their leaf nodes
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        
        // Compare the leaf node sequences
        return leaves1.equals(leaves2);
    }

    /**
     * Helper function to collect leaf values from a binary tree.
     * 
     * @param root The root node of the tree to traverse.
     * @param leaves The list to store leaf values.
     */
    private void collectLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;
        
        // If the node is a leaf (no left and no right child), add it to the list
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            // Otherwise, traverse both subtrees
            collectLeaves(root.left, leaves);
            collectLeaves(root.right, leaves);
        }
    }

    public static void main(String[] args) {
        // Example to test the leafSimilar method
        LeafSimilar solution = new LeafSimilar();
        
        // Tree 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        
        // Tree 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.left.right.right = new TreeNode(4);
        root2.right.left = new TreeNode(9);
        root2.right.right = new TreeNode(8);
        
        // Test the leafSimilar method
        boolean result = solution.leafSimilar(root1, root2);
        
        // Output the result
        System.out.println("Are the leaf sequences similar? " + result);
    }
}
