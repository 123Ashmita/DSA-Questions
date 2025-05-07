package day7;
import java.util.*;

public class PreorderTraversal {

    // Definition for a binary tree node.
    static class TreeNode {
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

        public static List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            preorder(root, result);
            return result;
        }

        private static void preorder(TreeNode root, List<Integer> result) {
            if (root == null)
                return;
            result.add(root.val);            // Visit node
            preorder(root.left, result);     // Traverse left
            preorder(root.right, result);    // Traverse right
        }

    // Main method to test the traversal
    public static void main(String[] args) {
    	TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode root = new TreeNode(1, null, node2);
        
        List<Integer> preorder = preorderTraversal(root);

        System.out.println("Preorder Traversal:");
        for (int val : preorder) {
            System.out.print(val + " ");
        }
    }
}
