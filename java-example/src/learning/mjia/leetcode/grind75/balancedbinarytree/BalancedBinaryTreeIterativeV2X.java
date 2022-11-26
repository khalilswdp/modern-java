package learning.mjia.leetcode.grind75.balancedbinarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BalancedBinaryTreeIterativeV2X {

    public boolean isBalanced(TreeNode root) {
        // iterative
        if (root == null) {
            return true;
        }
        Deque<TreeNode> toVisit = new ArrayDeque<>();
        Map<TreeNode, Integer> depth = new HashMap<>();
        toVisit.push(root);
        while (!toVisit.isEmpty()) {
            TreeNode current = toVisit.peek();
            if (current != null) {
                if (current.left == null && current.right == null) {
                    toVisit.pop();
                    depth.put(current, 0);
                } else if (current.left != null && !depth.containsKey(current.left)) {
                    toVisit.push(current.left);
                } else if (current.right != null && !depth.containsKey(current.right)) {
                    toVisit.push(current.right);
                } else {
                    toVisit.pop();
                    int right = depth.getOrDefault(current.right, -1);
                    int left = depth.getOrDefault(current.left, -1);
                    int max = 1 + Math.max(right, left);
                    int absDiff = Math.abs(right - left);
                    if (absDiff < 2) {
                        depth.put(current, max);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

