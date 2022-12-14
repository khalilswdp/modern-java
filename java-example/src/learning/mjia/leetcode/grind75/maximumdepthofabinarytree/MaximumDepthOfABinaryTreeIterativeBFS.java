package learning.mjia.leetcode.grind75.maximumdepthofabinarytree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepthOfABinaryTreeIterativeBFS {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> toCheck = new ArrayDeque<>();
        int depth = 0;
        toCheck.add(root);

        while (!toCheck.isEmpty()) {
            int numberInLevel = toCheck.size();
            while (numberInLevel-- > 0) {
                TreeNode current = toCheck.pop();
                if (current.right != null) {
                    toCheck.add(current.right);
                }
                if (current.left != null) {
                    toCheck.add(current.left);
                }
            }
            depth++;
        }

        return depth;
    }
}


