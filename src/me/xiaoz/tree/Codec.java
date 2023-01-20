package me.xiaoz.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static final String NULL = "#";
    public static final String SEPARATOR = ",";

    // Encodes a tree to a single string.
    public String serializeBFS(TreeNode root) {
        if (root == null) return null;
        StringBuilder builder = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                builder.append(NULL).append(SEPARATOR);
            } else {
                builder.append(node.val).append(SEPARATOR);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeBFS(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split(SEPARATOR);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;
        while (i < nodes.length && !queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (nodes[i].equals(NULL)) {
                cur.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                cur.left = left;
                queue.offer(left);
            }
            i++;

            if (nodes[i].equals(NULL)) {
                cur.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                cur.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder builder = new StringBuilder();
        traverse(root, builder);
        return builder.toString();
    }

    private void traverse(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(NULL).append(SEPARATOR);
            return;
        }
        builder.append(root.val).append(SEPARATOR);
        traverse(root.left, builder);
        traverse(root.right, builder);
    }

    int i = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] nodes = data.split(SEPARATOR);
        i = 0;
        return buildPreOrder(nodes);
    }

    private TreeNode buildPreOrder(String[] nodes) {
        if (i >= nodes.length) return null;
        String val = nodes[i++];
        if (val.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildPreOrder(nodes);
        node.right = buildPreOrder(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node4.right = new TreeNode(5);
        String serialize = new Codec().serializeBFS(node);
        System.out.println(serialize);
        System.out.println(new Codec().deserializeBFS(serialize));
    }
}