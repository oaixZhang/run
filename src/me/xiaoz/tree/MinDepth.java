package me.xiaoz.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return res;
                }
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new Codec().deserializeBFS("1,2,3,#,#,4,#,#,5,#,#,");
        System.out.println(new MinDepth().minDepth(root));
    }

}
