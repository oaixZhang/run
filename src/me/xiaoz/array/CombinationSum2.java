package me.xiaoz.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    private void dfs(int[] candidates, int i, int target) {

        if (sum == target) {
            res.add(new LinkedList<>(track));
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            track.addLast(candidates[j]);
            sum += candidates[j];
            dfs(candidates, j + 1, target);
            track.removeLast();
            sum -= candidates[j];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
