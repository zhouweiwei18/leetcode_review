package com.nuaa.main.bfs;

public class Solution_200 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    backtracking(grid, m, n, i, j);
                }
            }
        }
        return count;
    }

    public void backtracking(char[][] grid, int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') return;
        grid[x][y] = '0';
        for (int i = 0; i < directions.length; i++) {
            int x1 = x + directions[i][0];
            int y1 = y + directions[i][1];
            backtracking(grid, m, n, x1, y1);
        }
    }

}
