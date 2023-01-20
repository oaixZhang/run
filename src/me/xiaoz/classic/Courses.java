package me.xiaoz.classic;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Courses {
    boolean hasCycle;

    boolean[] visited;
    boolean[] onPath;
    LinkedList<Integer> track;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return IntStream.range(0, numCourses).toArray();
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        track = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            traverse(graph, i);
        }
        if (hasCycle) return new int[0];

        Collections.reverse(track);
        int[] res = new int[numCourses];
        for (int i = 0; i < track.size(); i++) {
            res[i] = track.get(i);
        }
        return res;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (onPath[i]) hasCycle = true;
        if (hasCycle || visited[i]) return;
        visited[i] = true;
        onPath[i] = true;
        for (int neighbor : graph[i]) {
            traverse(graph, neighbor);
        }
        track.addLast(i);
        onPath[i] = false;
    }


    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] ints : prerequisites) {
            int to = ints[0];
            int from = ints[1];
            graph[from].add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Courses().findOrder(2, new int[][]{{1, 0}})));
    }
}
