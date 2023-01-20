package me.xiaoz.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int j = start; j < nums.length; j++) {
            if (j > start && nums[j] == nums[j - 1]) {
                continue;
            }
            track.add(nums[j]);
            dfs(nums, j + 1);
            track.removeLast();
        }
    }
}
