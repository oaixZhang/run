package me.xiaoz.tree;

public class BuildTreePreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int count = index - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + count, inorder, inStart, index - 1);
        root.right = buildTree(preorder, preStart + count + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}
