package learning.mjia.leetcode.grind75.lowestcommonancestorofabinarysearchtree;

public class LowestCommonAncestorOfABinarySearchTreeOLognIterativeX {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}

