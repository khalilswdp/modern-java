package learning.mjia.leetcode.grind75.maximumdepthofabinarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfABinaryTreeRecursive {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}


