package me.xiaoz.tree;

public class BuildTreeInPost {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd)
            return null;
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int count = index - inStart;
        root.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + count - 1);
        root.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + count, postEnd - 1);
        return root;
    }
}
