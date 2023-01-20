package me.xiaoz.array;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;

        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int cur) {
        res.add(new LinkedList<>(track));
        while (cur < nums.length) {
            track.add(nums[cur]);
            dfs(nums, ++cur);
            track.removeLast();
        }
    }

}
