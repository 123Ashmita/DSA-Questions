package day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidBST {
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
    public static boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean checkBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return checkBST(root.left, min, root.val) &&
               checkBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
    	TreeNode node5 = new TreeNode(6);
    	TreeNode node4 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4,node4,node5);
        TreeNode node2 = new TreeNode(1);
        TreeNode root = new TreeNode(5,node2,node3);

        boolean result = isValidBST(root);

        System.out.println(result);
    }
}
