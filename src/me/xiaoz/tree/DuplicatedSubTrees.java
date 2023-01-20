package me.xiaoz.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DuplicatedSubTrees {
    public static final String SEP = ",";
    List<TreeNode> res;
    HashMap<String, Integer> mem;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return null;
        }
        res = new ArrayList<>();
        mem = new HashMap<>();
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String rootString = left + SEP + right + SEP + root.val;
        Integer current = mem.getOrDefault(rootString, 0);
        if (current == 1) {
            res.add(root);
        }
        mem.put(rootString, current + 1);
        return rootString;
    }
}
