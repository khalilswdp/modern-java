package learning.mjia.leetcode.grind75.lowestcommonancestorofabinarysearchtree.extras;

import learning.mjia.leetcode.grind75.lowestcommonancestorofabinarysearchtree.TreeNode;

public class LowestCommonAncestorOfABinarySearchTreeOLognIterativeShorter {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (areSameSign(current.val - p.val, current.val - q.val)) {
            current =  p.val > current.val ? current.right : current.left;
        }
        return current;
    }

    private static boolean areSameSign(int a, int b) {
        return ((a < 0) && (b < 0)) || ((a > 0) && (b > 0));
    }
}

