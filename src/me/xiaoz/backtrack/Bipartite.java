package me.xiaoz.backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    boolean res;
    boolean[] color;
    boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        color = new boolean[graph.length];
        visited = new boolean[graph.length];
        res = true;
        for (int i = 0; i < graph.length; i++) {
            if (visited[i])
                continue;
            bfs(graph, i);
        }
        return res;
    }

    private void bfs(int[][] graph, int i) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.offer(i);
        while (!queue.isEmpty() && res) {
            int poll = queue.poll();
            for (int neighbor : graph[poll]) {
                if (visited[neighbor]) {
                    if (color[neighbor] == color[poll])
                        res = false;
                } else {
                    color[neighbor] = !color[poll];
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    private void traverse(int[][] graph, int i, boolean b) {
        if (!res) return;
        if (visited[i])
            return;
        visited[i] = true;
        color[i] = b;
        int[] neighbors = graph[i];
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                traverse(graph, neighbor, !b);
            } else {
                if (color[i] == color[neighbor])
                    res = false;
            }
        }
    }

}
