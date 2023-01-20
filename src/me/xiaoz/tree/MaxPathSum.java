package me.xiaoz.tree;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MaxPathSum {
    int res;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return res;
        res = Integer.MIN_VALUE;
        traverse(root);
        return res;
    }

    private int traverse(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(traverse(node.left), 0);
        int right = Math.max(traverse(node.right), 0);
        res = Math.max(left + right + node.val, res);
        return Math.max(left, right) + node.val;
    }


    public Collection<List<String>> maxPathSum(String input) {
        return null;
    }

    public static void main(String[] args) {

//        MaxPathSum sum = new MaxPathSum();
//        Method method = null;
//        try {
////            method = strings.getClass().getMethod("add", Object.class);
//            method = sum.getClass().getMethod("maxPathSum", String.class);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        Type genericReturnType = method.getGenericReturnType();
//        System.out.println(genericReturnType);

        TreeNode root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new MaxPathSum().maxPathSum(root));


    }
}
