package me.xiaoz.tree;

import java.util.List;

public class BuildTree {
    public static TreeNode build(List<Integer> list) {
        if (list == null || list.size() == 0)
            return null;

        return buildTree(list, 0, list.size() - 1);
    }

    private static TreeNode buildTree(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        Integer val = list.get(start);
        if (val == null)
            return null;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(list, 2 * start + 1, end);
        root.right = buildTree(list, 2 * start + 2, end);
        return root;
    }
}
