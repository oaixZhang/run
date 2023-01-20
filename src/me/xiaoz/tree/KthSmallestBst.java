package me.xiaoz.tree;

public class KthSmallestBst {
    int res = 0, count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node4.right = new TreeNode(5);
        node2.left = node;
        node2.right = node3;
        node4.left = node2;
        System.out.println(new KthSmallestBst().kthSmallest(node4, 1));
    }
}
