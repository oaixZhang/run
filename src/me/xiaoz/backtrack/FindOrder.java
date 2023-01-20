package me.xiaoz.backtrack;

import java.util.*;

public class FindOrder {

    boolean hasCycle = false;
    boolean[] visited;
    boolean[] path;
    LinkedList<Integer> track;

    int[] indegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
//        visited = new boolean[numCourses];
//        path = new boolean[numCourses];
//        track = new LinkedList<>();
//        for (int i = 0; i < graph.length; i++) {
//            traverse(graph, i);
//        }
//        if (hasCycle)
//            return new int[]{};
//
//        Collections.reverse(track);
//        int[] res = new int[numCourses];
//        for (int i = 0; i < track.size(); i++) {
//            res[i] = track.get(i);
//        }
//        return res;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        int[] order = new int[numCourses];

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            order[count] = poll;
            count++;
            for (int to : graph[poll]) {
                indegree[to]--;
                if (indegree[to] == 0)
                    queue.offer(to);
            }
        }
        if (count != numCourses)
            return new int[]{};
        return order;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (path[i])
            hasCycle = true;
        if (hasCycle || visited[i]) return;
        visited[i] = true;
        path[i] = true;
        for (int neighbor : graph[i]) {
            traverse(graph, neighbor);
        }
        path[i] = false;
        track.addLast(i);
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] ints : prerequisites) {
            int to = ints[0];
            int from = ints[1];
            indegree[to]++;
            graph[from].add(to);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindOrder().findOrder(2, new int[][]{{1, 0}})));
    }
}
