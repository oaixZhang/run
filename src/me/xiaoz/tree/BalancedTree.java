package me.xiaoz.tree;

public class BalancedTree {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return balanced;
        subHeight(root);
        return balanced;
    }

    private int subHeight(TreeNode root) {
        if (root == null) return 0;
        int left = subHeight(root.left);
        int right = subHeight(root.right);
        if (Math.abs(left - right) > 1) balanced = false;
        return Math.max(left, right) + 1;
    }
}
