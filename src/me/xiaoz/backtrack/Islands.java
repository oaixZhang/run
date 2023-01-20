package me.xiaoz.backtrack;

import java.util.LinkedList;
import java.util.Queue;

public class Islands {
    int num;

    Queue<int[]> queue;

    int res;

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    backtrack(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void backtrack(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1)
            return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        backtrack(grid, i, j - 1);
        backtrack(grid, i, j + 1);
        backtrack(grid, i - 1, j);
        backtrack(grid, i + 1, j);
    }


    private void bfs(int i, int rows, int j, int columns, char[][] grid) {
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            if (ints[0] < 0 || ints[0] >= rows || ints[1] < 0 || ints[1] >= columns)
                continue;
            i = ints[0];
            j = ints[1];
            if (grid[i][j] == '0')
                continue;
            if (grid[i][j] == '1')
                grid[i][j] = '0';
            queue.offer(new int[]{i - 1, j});
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i, j - 1});
            queue.offer(new int[]{i, j + 1});
        }
    }

    private void dfs(int i, int rows, int j, int columns, char[][] grid) {
        if (i < 0 || i >= rows || j < 0 || j >= columns)
            return;
        if (grid[i][j] == '0')
            return;
        if (grid[i][j] == '1')
            grid[i][j] = '0';
        dfs(i - 1, rows, j, columns, grid);
        dfs(i + 1, rows, j, columns, grid);
        dfs(i, rows, j - 1, columns, grid);
        dfs(i, rows, j + 1, columns, grid);
    }

    public static void main(String[] args) {
        System.out.println(new Islands().numIslands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        }));
    }

}
