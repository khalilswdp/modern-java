package learning.mjia.leetcode.grind75.lowestcommonancestorofabinarysearchtree;

public class LowestCommonAncestorOfABinarySearchTreeOLognIterativeX {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (current.val > p.val && current.val > q.val) {
                current = current.left;
            } else if (current.val < p.val && current.val < q.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }
}

