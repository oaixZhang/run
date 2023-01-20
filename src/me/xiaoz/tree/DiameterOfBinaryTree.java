package me.xiaoz.tree;

public class DiameterOfBinaryTree {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new Codec().deserializeBFS("1,2,3,#,4,5,#");
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

}