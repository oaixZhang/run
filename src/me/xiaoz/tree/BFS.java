package me.xiaoz.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print("null ");
            } else {
                System.out.print(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    public static void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
    }
}
