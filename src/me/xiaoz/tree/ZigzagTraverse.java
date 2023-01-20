package me.xiaoz.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraverse {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                count--;
                if (node == null) break;
                if (level % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagTraverse().zigzagLevelOrder(
                new Codec().deserializeBFS("1,2,3,4,5,6,7")
        ));
    }
}
