package me.xiaoz.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {

    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i - 1 >= 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            track.addLast(nums[i]);
            used[i] = true;
            dfs(nums);
            used[i] = false;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 2}));
    }
}
