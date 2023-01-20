package me.xiaoz.tree;

public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode rightMin = getMin(root.right);
            root.right = deleteNode(root.right, rightMin.val);
            rightMin.left = root.left;
            rightMin.right = root.right;
            root = rightMin;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        TreeNode min = node;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }
}
