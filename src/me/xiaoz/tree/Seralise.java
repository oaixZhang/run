package me.xiaoz.tree;

import java.util.Arrays;
import java.util.LinkedList;

public class Seralise {
    private StringBuilder builder;
    public static final String SEP = ",";
    public static final String NULL = "#";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        builder = new StringBuilder();
        traverse(root);

        String s = builder.toString();
        System.out.println(s);
        return s;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            builder.append(NULL).append(SEP);
            return;
        }
        builder.append(root.val).append(SEP);
        traverse(root.left);
        traverse(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] strings = data.split(SEP);
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        TreeNode root = new TreeNode(Integer.parseInt(list.removeFirst()));
        root.left = buildPreOrder(list);
        root.right = buildPreOrder(list);
        return root;
    }

    private TreeNode buildPreOrder(LinkedList<String> list) {
        if (list.size() == 0) return null;
        String s = list.removeFirst();
        if (NULL.equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildPreOrder(list);
        root.right = buildPreOrder(list);
        return root;
    }
}
