package learning.mjia.leetcode.grind75.lowestcommonancestorofabinarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LowestCommonAncestorOfABinarySearchTreeOLognIterativeV2X {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> toVisit = new ArrayDeque<>();
        toVisit.add(root);

        while (!toVisit.isEmpty()) {
            int toVisitSize = toVisit.size();
            for (int i = 0; i < toVisitSize; i++) {
                TreeNode current = toVisit.pop();
                if (current.left != null && current.val > p.val && current.val > q.val) {
                    toVisit.add(current.left);
                } else if (current.right != null && current.val < p.val && current.val < q.val) {
                    toVisit.add(current.right);
                } else {
                    return current;
                }
            }
        }

        return null;
    }
}

