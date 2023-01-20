package me.xiaoz.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;


    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        used = new boolean[nums.length];
        traverse(nums);
        return res;
    }

    private void traverse(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            track.addLast(nums[i]);
            traverse(nums);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(IntStream.range(0, 3).toArray()));
    }
}
