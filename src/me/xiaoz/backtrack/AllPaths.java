package me.xiaoz.backtrack;

import java.util.LinkedList;
import java.util.List;

public class AllPaths {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null)
            return res;
        traverse(graph, 0);
        return res;

    }


    private void traverse(int[][] graph, int i) {
        track.addLast(i);
        if (i == graph.length - 1) {
            res.add(new LinkedList<>(track));
        }
        int[] neighbors = graph[i];
        for (int neighbor : neighbors) {
            traverse(graph, neighbor);
        }
        track.removeLast();
    }

    public static void main(String[] args) {
        System.out.println(new AllPaths().allPathsSourceTarget(new int[][]{
                {1, 2}, {3}, {3}, {}
        }));
    }
}
