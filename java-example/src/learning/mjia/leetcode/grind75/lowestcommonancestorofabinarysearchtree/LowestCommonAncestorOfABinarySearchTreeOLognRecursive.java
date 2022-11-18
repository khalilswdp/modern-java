package learning.mjia.leetcode.grind75.lowestcommonancestorofabinarysearchtree;

public class LowestCommonAncestorOfABinarySearchTreeOLognRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) {
            return p;
        } else {
            return getLowestCommonTreeNode(root, p, q);
        }
    }

    private TreeNode getLowestCommonTreeNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root.left != null && p.val < root.val && q.val < root.val) {
            return getLowestCommonTreeNode(root.left, p, q);
        } else if (root.right != null && p.val > root.val && q.val > root.val) {
            return getLowestCommonTreeNode(root.right, p, q);
        } else {
            return root;
        }
    }
}

