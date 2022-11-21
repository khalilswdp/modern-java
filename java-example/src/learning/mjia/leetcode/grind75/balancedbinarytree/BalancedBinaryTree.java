package learning.mjia.leetcode.grind75.balancedbinarytree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
    }
    public static boolean isBalanced(TreeNode root) {
        return treeHeight(root).isBalanced;
    }


    private static BBT treeHeight(TreeNode root) {
        if (root == null) {
            return new BBT(true, 0);
        } else {
            BBT bbtLeft = treeHeight(root.left);
            BBT bbtRight = treeHeight(root.right);
            return new BBT(bbtLeft.isBalanced
                    && bbtRight.isBalanced
                    && Math.abs(bbtLeft.height - bbtRight.height) < 2,
                    1 + Math.max(bbtLeft.height, bbtRight.height));
        }
    }

    static class BBT {
        boolean isBalanced;
        int height;

        public BBT(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}

