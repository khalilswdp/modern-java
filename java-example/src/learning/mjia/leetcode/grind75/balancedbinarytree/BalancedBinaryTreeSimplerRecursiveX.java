package learning.mjia.leetcode.grind75.balancedbinarytree;

public class BalancedBinaryTreeSimplerRecursiveX {
    private static boolean balance;

    public static boolean isBalanced(TreeNode root) {
        balance = true;
        height(root);
        return balance;    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int heightRight = height(root.right);
            int heightLeft = height(root.left);
            balance = balance && Math.abs(heightRight - heightLeft) < 2;
            return 1 + Math.max(heightRight, heightLeft);
        }
    }
}

