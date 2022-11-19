package learning.mjia.leetcode.grind75.balancedbinarytree;

public class BalancedBinaryTreeV2 {
    public boolean isBalanced(TreeNode root) {
        return checkTreeIsBalanced(root)[0] == 1;
    }

    private int[] checkTreeIsBalanced(TreeNode root) {
        if (root == null) {
            return new int[] { 1, 0 };
        } else if (root.left == null && root.right == null) {
            return new int[] { 1, 1 };
        } else {
            int[] left = checkTreeIsBalanced(root.left);
            int[] right = checkTreeIsBalanced(root.right);
            return new int[] {
                    (
                            (left[0] == 1 && right[0] == 1)
                                    && (Math.abs(left[1] - right[1]) < 2))
                            ? 1 : 0, 1 + Math.max(left[1], right[1])};
        }
    }
}
