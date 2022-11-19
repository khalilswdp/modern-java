package learning.mjia.leetcode.grind75.balancedbinarytree;

import java.util.*;

public class BalancedBinaryTreeIterative {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Map<TreeNode, Integer> heights = new HashMap<>();
        Deque<TreeNode> toVisitStack = new ArrayDeque<>();
        toVisitStack.add(root);

        while (!toVisitStack.isEmpty()) {
            TreeNode current = toVisitStack.peek();
            // If it is already in heights , that means it is already visited. Thus redundant to check toVisitStack doesn't contain it.
            if (current.left != null && !heights.containsKey(current.left)) {
                current = current.left;
                toVisitStack.push(current);
            } else if (current.right != null && !heights.containsKey(current.right)) {
                current = current.right;
                toVisitStack.push(current);
            } else {
                // We're using a stack, thus we're sure heights contains the values as long as the keys are not null
                // No need to use : && heights.containsKey(current.left)
                // No need to use : && heights.containsKey(current.right)
                int leftHeight = current.left != null ? heights.get(current.left) : 0;
                int rightHeight = current.right != null ? heights.get(current.right) : 0;

                int absDiff = Math.abs(leftHeight - rightHeight);
                if (absDiff > 1) {
                    return false;
                }
                int maxHeight = Math.max(leftHeight, rightHeight);
                heights.put(current, 1 + maxHeight);
                toVisitStack.pop();
            }
        }
        return true;
    }
}

