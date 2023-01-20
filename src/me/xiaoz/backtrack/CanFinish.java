package me.xiaoz.backtrack;

import java.util.LinkedList;
import java.util.List;

public class CanFinish {
    boolean canFinish = true;

    boolean[] visited;
    boolean[] onPath;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) return true;
        List<Integer>[] graph = buildGraph(prerequisites, numCourses);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return canFinish;
    }

    private void traverse(List<Integer>[] graph, int cur) {
        if (onPath[cur]) {
            canFinish = false;
            return;
        }
        if (!canFinish || visited[cur]) return;
        onPath[cur] = true;
        visited[cur] = true;
        for (int i : graph[cur]) {
            traverse(graph, i);
        }
        onPath[cur] = false;
    }

    private List<Integer>[] buildGraph(int[][] prerequisites, int num) {
        List<Integer>[] graph = new List[num];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] ints : prerequisites) {
            int from = ints[0];
            int to = ints[1];
            graph[from].add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(new CanFinish().canFinish(3, new int[][]{{1, 0}, {0, 1}}));
    }
}
