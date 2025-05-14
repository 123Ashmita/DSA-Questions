package com.day12;

/**
 * The MinDifferenceBST class provides a method to find minimum difference between two nodes
 * Example:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 */
public class MinDifferenceBST {
	static Integer prev=null;
	static int minDiff=Integer.MAX_VALUE;

    // TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    //logic
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    //inorder traversal
       private static void inOrder(TreeNode node ) {
        if (node == null) return;
        inOrder(node.left);
        if(prev != null) {
            minDiff=Math.min(minDiff,node.val-prev);
        }
        prev=node.val;
        inOrder(node.right);

    } 
       /**
        * Main method to test the minDiffInBST method with a sample input.
        */
    public static void main(String[] args) {
    	//manually creating nodes
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        MinDifferenceBST solution = new MinDifferenceBST();
        System.out.println("Min Difference between two node : "+solution.minDiffInBST(root));
    }
}
