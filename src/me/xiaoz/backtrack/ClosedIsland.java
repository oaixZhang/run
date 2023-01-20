package me.xiaoz.backtrack;

public class ClosedIsland {
    int num;
    int val;

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        num = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    val = 1;
                    dfs(i, rows, j, columns, grid);
                    num += val;
                }
            }
        }

        return num;
    }

    private void dfs(int i, int rows, int j, int columns, int[][] grid) {
        if (i < 0 || i >= rows || j < 0 || j >= columns) {
            val = 0;
            return;
        }

        if (grid[i][j] == 1)
            return;
        grid[i][j] = 1;
        dfs(i - 1, rows, j, columns, grid);
        dfs(i + 1, rows, j, columns, grid);
        dfs(i, rows, j - 1, columns, grid);
        dfs(i, rows, j + 1, columns, grid);
    }

    public static void main(String[] args) {
        System.out.println(new ClosedIsland().closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
        }));
    }
}
