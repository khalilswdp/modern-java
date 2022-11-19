package learning.mjia.leetcode.grind75.balancedbinarytree;

public class BalancedBinaryTreeSimplerV2 {

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightRight = height(root.right);
        int heightLeft = height(root.left);
        int absDiff = Math.abs(heightRight - heightLeft);
        if (heightLeft == -1 || heightRight == -1 || absDiff > 1) {
            return -1;
        } else {
            return 1 + Math.max(heightRight, heightLeft);
        }
    }
}

