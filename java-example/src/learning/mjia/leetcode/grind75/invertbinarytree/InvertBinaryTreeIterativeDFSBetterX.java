package learning.mjia.leetcode.grind75.invertbinarytree;

import java.util.Stack;

public class InvertBinaryTreeIterativeDFSBetterX {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> toVisit = new Stack<>();
        toVisit.push(root);
        while (!toVisit.isEmpty()) {
            TreeNode currentNode = toVisit.pop();
            if (currentNode != null) {
                TreeNode tempo = currentNode.left;
                currentNode.left = currentNode.right;
                currentNode.right = tempo;

                if (currentNode.left != null) {
                    toVisit.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    toVisit.push(currentNode.right);
                }
            }
        }
        return root;
    }
}
