package me.xiaoz.dp;

import me.xiaoz.tree.Codec;
import me.xiaoz.tree.TreeNode;

import java.util.HashMap;

public class RobTree {
    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        int max = Math.max(rob(root, true), rob(root, false));
        memo.put(root, max);

        return max;
    }

    private int rob(TreeNode root, boolean doRob) {
        if (root == null) return 0;
        if (doRob) {
            return root.val + rob(root.left, false) + rob(root.right, false);
        } else {
            return rob(root.left) + rob(root.right);
        }
    }

    int rob1(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
    arr[0] 表示不抢 root 的话，得到的最大钱数
    arr[1] 表示抢 root 的话，得到的最大钱数 */
    int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{not_rob, rob};
    }


    public static void main(String[] args) {
        me.xiaoz.tree.TreeNode root = new Codec().deserializeBFS("3,4,5,1,3,#,1");
        System.out.println(new RobTree().rob(root));
    }
}
