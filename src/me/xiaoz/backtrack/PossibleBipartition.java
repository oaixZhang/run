package me.xiaoz.backtrack;

import java.util.LinkedList;
import java.util.List;

public class PossibleBipartition {
    boolean possible = true;

    boolean[] visited;
    boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n, dislikes);
        visited = new boolean[n + 1];
        color = new boolean[n + 1];

        for (int i = 1; i < graph.length; i++) {
            if (!visited[i])
                traverse(graph, i);
        }

        return possible;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (!possible) return;

        visited[i] = true;
        for (int neighbor : graph[i]) {
            if (visited[neighbor]) {
                if (color[i] == color[neighbor])
                    possible = false;
            } else {
                color[neighbor] = !color[i];
                traverse(graph, neighbor);
            }
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] dislike : dislikes) {
            int i = dislike[0];
            int j = dislike[1];
            graph[i].add(j);
            graph[j].add(i);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(new PossibleBipartition().possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
    }
}
