package learning.mjia.leetcode.grind75.lowestcommonancestorofabinarysearchtree;

public class LowestCommonAncestorOfABinarySearchTreeOLognIterative {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        if (p.val == q.val) {
            return p;
        } else {
            while (current != null) {
                if (current.left != null && p.val < current.val && q.val < current.val) {
                    current = current.left;
                } else if (current.right != null && p.val > current.val && q.val > current.val) {
                    current = current.right;
                } else {
                    return current;
                }
            }
        }
        return null;
    }
}

