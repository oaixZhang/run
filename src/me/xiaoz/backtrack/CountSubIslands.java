package me.xiaoz.backtrack;

public class CountSubIslands {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (grid1 == null || grid2 == null)
            return 0;
        int res = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                    res += 1;
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
