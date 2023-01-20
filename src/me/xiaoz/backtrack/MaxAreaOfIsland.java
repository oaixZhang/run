package me.xiaoz.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null)
            return 0;
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{m, n});
        int res = 0;
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            m = ints[0];
            n = ints[1];
            if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length)
                continue;
            if (grid[m][n] == 1) {
                res++;
                grid[ints[0]][ints[1]] = 0;
                queue.add(new int[]{m - 1, n});
                queue.add(new int[]{m + 1, n});
                queue.add(new int[]{m, n - 1});
                queue.add(new int[]{m, n + 1});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {1, 1, 1, 0},
                {1, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        }));
    }
}
