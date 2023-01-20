package me.xiaoz.array;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> res;
    LinkedList<Integer> track;
    int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        sum = 0;
        dfs(candidates, 0, target);
        return res;
    }

    private void dfs(int[] candidates, int cur, int target) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (sum > target) return;
        for (int j = cur; j < candidates.length; j++) {
            track.addLast(candidates[j]);
            sum += candidates[j];
            dfs(candidates, j, target);
            sum -= candidates[j];
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
