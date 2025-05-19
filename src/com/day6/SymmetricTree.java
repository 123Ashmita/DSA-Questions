package com.day6;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	} // constructor

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/**
 * This class has a method to check symmetric tree. example-- Input: root =
 * [1,2,2,3,4,4,3] Output: true
 */
public class SymmetricTree {

	/**
	 * Main method to check if the binary tree is symmetric.
	 * 
	 * @param root Root node of the binary tree
	 * @return true if the tree is symmetric, false otherwise
	 */
	public boolean isSymmetric(TreeNode root) {
		// If the tree is empty, it's symmetric
		if (root == null)
			return true;

		// Call helper method to compare left and right subtrees
		return isMirror(root.left, root.right);
	}

	/**
	 * Helper method to check if two subtrees are mirror images of each other.
	 * 
	 * @param left  Left subtree
	 * @param right Right subtree
	 * @return true if they are mirror images, false otherwise
	 */
	private boolean isMirror(TreeNode left, TreeNode right) {
		// If both nodes are null, they are symmetric
		if (left == null && right == null)
			return true;

		// If one of them is null and the other is not, not symmetric
		if (left == null || right == null)
			return false;

		// If values of the nodes are different, not symmetric
		if (left.val != right.val)
			return false;

		// Recursively check outer and inner pairs
		return isMirror(left.left, right.right) && isMirror(left.right, right.left);
	}

	/**
	 * Main method to test the symmetry checker. Creates a test binary tree and
	 * prints whether it's symmetric.
	 */
	public static void main(String[] args) {
		SymmetricTree solution = new SymmetricTree();

		// Creating the test tree:
		// 1
		// / \
		// 2 2
		// / \ / \
		// 3 4 4 3

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		// Check if the tree is symmetric
		System.out.println(solution.isSymmetric(root));
	}
}