package learning.mjia.leetcode.grind75.invertbinarytree;

public class InvertBinaryTreeRecursiveX {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempo = root.left;
        root.left = root.right;
        root.right = tempo;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
