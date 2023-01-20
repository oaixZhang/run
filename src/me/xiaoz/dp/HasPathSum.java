package me.xiaoz.dp;

import me.xiaoz.tree.TreeNode;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == root.right && root.val == targetSum)
            return true;
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

    boolean has;
    int current;

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return has;
    }

    public void traverse(TreeNode root, int targetSum) {
        if (root == null)
            return;
        current += root.val;
        if (root.left == root.right && current == targetSum)
            has = true;
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        current -= root.val;
    }

}
