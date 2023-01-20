package me.xiaoz.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track;
    int curSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) return res;
        track = new LinkedList<>();
        backtrack(0, candidates, target);
        return res;
    }

    private void backtrack(int index, int[] candidates, int target) {
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            track.addLast(candidate);
            curSum += candidate;
            backtrack(i, candidates, target);
            curSum -= candidate;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
