package me.xiaoz.array;

import java.util.LinkedList;
import java.util.List;

public class Combine {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) return res;
        dfs(1, n, k);
        return res;
    }

    private void dfs(int cur, int n, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        while (cur <= n) {
            track.add(cur);
            dfs(++cur, n, k);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
