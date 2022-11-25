package learning.mjia.leetcode.grind75.invertbinarytree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class InvertBinaryTreeIterativeV2 {
    public TreeNode invertTree(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.add(root);

        while (!toVisit.isEmpty()) {
            TreeNode current = toVisit.peek();
            if (current != null) {
                if (current.left != null && !visited.contains(current.left)) {
                    toVisit.add(current.left);
                } else if (current.right != null && !visited.contains(current.right)) {
                    toVisit.add(current.right);
                } else {
                    TreeNode tempo = current.right;
                    current.right = current.left;
                    current.left = tempo;
                    toVisit.pop();
                    visited.add(current);
                }
            } else {
                toVisit.pop();
            }
        }
        return root;

    }
}
