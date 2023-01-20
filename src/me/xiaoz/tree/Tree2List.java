package me.xiaoz.tree;

public class Tree2List {

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;

        root.right = root.left;
        root.left = null;
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
    }
}
