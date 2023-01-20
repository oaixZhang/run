package me.xiaoz.tree;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode cur, TreeNode min, TreeNode max) {
        if (cur == null) return true;
        if (min != null && cur.val <= min.val)
            return false;
        if (max != null && cur.val >= max.val)
            return false;
        return validate(cur.left, min, cur) && validate(cur.right, cur, max);
    }

    public static void main(String[] args) {
        TreeNode root = new Codec().deserializeBFS("5,4,6,#,#,3,7");
        System.out.println(new ValidBST().isValidBST(root));
    }
}
